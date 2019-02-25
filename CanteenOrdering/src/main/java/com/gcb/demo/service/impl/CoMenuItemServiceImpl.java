package com.gcb.demo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gcb.demo.dao.CoMenuItemMapper;
import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoMenuItem;
import com.gcb.demo.service.CoMenuItemService;
import com.gcb.demo.utils.DateUtil;
import com.gcb.demo.utils.SFTPUtil;
import com.gcb.demo.utils.StringUtil;

@Service
public class CoMenuItemServiceImpl implements CoMenuItemService {
	
	Logger logger = LoggerFactory.getLogger(CoMenuItemServiceImpl.class);
	
	private static String USERNAME;  // 服务器用户名
	private static String PASSWORD;  // 服务器密码
	private static String IP;        // 服务器IP
	private static String PORT;      // 服务器端口
	private static String UPLOAD_DIRECTORY; // 文件上传目录
	private static String URL_PREFIX;       // 访问图片的前缀

	@Autowired
	private CoMenuItemMapper coMenuItemMapper;

	/**
	 * 上传图片
	 */
	@SuppressWarnings("static-access")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public AvailableResult fileUpload(MultipartFile multipartFile, HttpServletRequest request) {
		// 判断文件是否为空
		if (!multipartFile.isEmpty()) {
			try {
				logger.info(">>>>>>>>>>开始上传图片>>>>>>>>>>");
				
				// 初始化配置
				initConfig();
				
				// 获取图片后缀
				String suffix = getPictureSuffix(multipartFile.getOriginalFilename());
				
				// 重新生成图片名字
				String newName = new Sid().next() + "." + suffix;
				
				// 文件保存路径
				String filePath = request.getSession().getServletContext().getRealPath("/") + newName;
				logger.info(">>>>>>>>>>文件保存路径=" + filePath);
				
				// 转存文件
				multipartFile.transferTo(new File(filePath));
				
				// 上传文件
				SFTPUtil sftp = new SFTPUtil(USERNAME, PASSWORD, IP, Integer.parseInt(PORT));
				sftp.login();
				File file = new File(filePath);
				InputStream is = new FileInputStream(file);

				sftp.upload(UPLOAD_DIRECTORY, newName, is);
				sftp.logout();
				String url = URL_PREFIX + newName;
				logger.info(">>>>>>>>>>访问图片的url=" + url);
				logger.info(">>>>>>>>>>结束上传图片>>>>>>>>>>");
				return AvailableResult.ok(url);
			} catch (Exception e) {
				logger.error(">>>>>>>>>>上传图片出现异常", e.getMessage());
				e.printStackTrace(); 
				return AvailableResult.errorException(">>>>>>>>>>上传图片出现异常，原因为：" + e.getMessage());
			}
		} else {
			logger.error(">>>>>>>>>>上传图片为空>>>>>>>>>>");
			return AvailableResult.errorMsg("上传图片为空");
		}
	}

	/**
	 * 初始化配置
	 */
	private void initConfig() {
		ResourceBundle res = ResourceBundle.getBundle("application");
		USERNAME = res.getString("upload.picture.server.username");
		PASSWORD = res.getString("upload.picture.server.password");
		IP = res.getString("upload.picture.server.ip");
		PORT = res.getString("upload.picture.server.port");
		UPLOAD_DIRECTORY = res.getString("upload.picture.server.directory");
		URL_PREFIX = res.getString("upload.picture.server.url.prefix");
	}

	/**
	 * 获取图片后缀
	 * @param originalFilename
	 * @return
	 */
	private String getPictureSuffix(String originalFilename) {
		String[] str = originalFilename.split(".");
		return str[1];
	}

	/**
	 * 保存菜单单品信息
	 */
	@SuppressWarnings("static-access")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public AvailableResult saveCoMenuItem(CoMenuItem coMenuItem) {
		try {
			logger.info(">>>>>>>>>>开始保存菜单单品信息>>>>>>>>>>");
			request.setCharacterEncoding("UTF-8");
			// 参数检查
			if (StringUtil.nullAndEmpty(coMenuItem.getItemName())) {
				return AvailableResult.errorMsg("菜单单品名称为空");
			}
			if (StringUtil.nullAndEmpty(coMenuItem.getItemUrl())) {
				return AvailableResult.errorMsg("菜单单品的图片url为空");
			}
			logger.info(">>>>>>>>>>请求参数-菜单单品名称=" + coMenuItem.getItemName() + ",菜单单品的图片url=" + coMenuItem.getItemUrl());
			CoMenuItem temp = new CoMenuItem();
			temp.setItemName(coMenuItem.getItemName());
			List<CoMenuItem> list = coMenuItemMapper.select(temp);
			if (list.isEmpty()) { // 如果该图片名称不存在，则保存
				coMenuItem.setItemId(new Sid().next());
				coMenuItem.setCreateTime(DateUtil.getCurrentTime());
				coMenuItemMapper.insert(coMenuItem);
			} else { // 如果存在，则修改其中的url
				CoMenuItem cItem = list.get(0);
				cItem.setItemUrl(coMenuItem.getItemUrl());
				cItem.setUpdateTime(DateUtil.getCurrentTime());
				coMenuItemMapper.updateByPrimaryKeySelective(cItem);
			}
			logger.info(">>>>>>>>>>结束保存菜单单品信息>>>>>>>>>>");
			return AvailableResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(">>>>>>>>>>保存菜单单品信息出现异常，原因为：" + e.getMessage());
			return AvailableResult.errorException(e.getMessage());
		}
	}
}
