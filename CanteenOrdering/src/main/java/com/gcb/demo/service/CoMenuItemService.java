package com.gcb.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoMenuItem;

public interface CoMenuItemService {

	/**
	 * 上传图片
	 * @param file
	 * @param request
	 * @return
	 */
	AvailableResult fileUpload(MultipartFile file, HttpServletRequest request);

	/**
	 * 保存菜单单品
	 * @param coMenuItem
	 * @return
	 */
	AvailableResult saveCoMenuItem(CoMenuItem coMenuItem);
}
