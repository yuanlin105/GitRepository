package com.gcb.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gcb.demo.dao.CoMenuItemMapper;
import com.gcb.demo.dao.CoMenuMapper;
import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoMenu;
import com.gcb.demo.po.CoMenuItem;
import com.gcb.demo.service.CoMenuService;
import com.gcb.demo.utils.DateUtil;
import com.gcb.demo.utils.StringUtil;
import com.gcb.demo.vo.CoMenuReqEx;
import com.gcb.demo.vo.CoMenuReqVo;
import com.gcb.demo.vo.CoMenuVo;

@Service
public class CoMenuServiceImpl implements CoMenuService {

	Logger logger = LoggerFactory.getLogger(CoMenuServiceImpl.class);

	@Autowired
	private CoMenuMapper coMenuMapper;

	@Autowired
	private CoMenuItemMapper coMenuItemMapper;

	/**
	 * 保存菜单
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AvailableResult saveCoMenu(CoMenuReqEx coMenuReqEx) {
		try {
			if (coMenuReqEx == null || coMenuReqEx.getList() == null) {
				return AvailableResult.errorMsg(">>>>>>>>>>请求参数为空>>>>>>>>>>");
			}
			logger.info(coMenuReqEx.toString());
			List<CoMenu> list = new ArrayList<CoMenu>();
			List<CoMenuReqVo> coMenuReqVos = coMenuReqEx.getList(); // 获取一天的数据
			for (CoMenuReqVo coMenuReqVo : coMenuReqVos) {
				List<CoMenuVo> coMenuVos = coMenuReqVo.getCoMenuVos(); // 获取一餐的数据
				if (!coMenuVos.isEmpty()) {
					for (CoMenuVo coMenuVo : coMenuVos) {
						CoMenu coMenu = new CoMenu();
						coMenu.setMenuWeek(coMenuReqVo.getMenuWeek());
						coMenu.setMenuMorningNoon(coMenuVo.getMenuMorningNoon());
						coMenu.setMenuContent(coMenuVo.getMenuContent());
						coMenu.setMenuGreetings(coMenuVo.getMenuGreetings());
						coMenu.setMenuFoodCulture(coMenuVo.getMenuFoodCulture());
						coMenu.setUpdateTime(DateUtil.getCurrentTime());
						list.add(coMenu);
					}
				} else {
					AvailableResult.errorMsg("菜单内容为空");
				}
			}
			if (!list.isEmpty()) {
				for (CoMenu coMenu : list) {
					CoMenu temp = new CoMenu();
					temp.setMenuWeek(coMenu.getMenuWeek());
					temp.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					List<CoMenu> tempList = coMenuMapper.select(temp);
					if (tempList.isEmpty()) {
						coMenuMapper.insert(coMenu);
					} else {
						coMenuMapper.updateByPrimaryKeySelective(coMenu);
					}
				}
			}
			return AvailableResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return AvailableResult.errorException(e.getMessage());
		}
	}

	/**
	 * 查询所有菜单
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public AvailableResult queryCoMenuList() {
		try {
			List<CoMenu> list = coMenuMapper.selectAll();
			if (!list.isEmpty()) {
				List<CoMenu> mondayCoMenus = new ArrayList<CoMenu>();
				List<CoMenu> tuesdayCoMenus = new ArrayList<CoMenu>();
				List<CoMenu> wednesdayCoMenus = new ArrayList<CoMenu>();
				List<CoMenu> thursdayCoMenus = new ArrayList<CoMenu>();
				List<CoMenu> fridayCoMenus = new ArrayList<CoMenu>();
				List<CoMenu> saturdayCoMenus = new ArrayList<CoMenu>();
				List<CoMenu> sundayCoMenus = new ArrayList<CoMenu>();
				for (CoMenu coMenu : list) {
					if ("monday".equals(coMenu.getMenuWeek())) {
						mondayCoMenus.add(coMenu);
					}
					if ("tuesday".equals(coMenu.getMenuWeek())) {
						tuesdayCoMenus.add(coMenu);
					}
					if ("wednesday".equals(coMenu.getMenuWeek())) {
						wednesdayCoMenus.add(coMenu);
					}
					if ("thursday".equals(coMenu.getMenuWeek())) {
						thursdayCoMenus.add(coMenu);
					}
					if ("friday".equals(coMenu.getMenuWeek())) {
						fridayCoMenus.add(coMenu);
					}
					if ("saturday".equals(coMenu.getMenuWeek())) {
						saturdayCoMenus.add(coMenu);
					}
					if ("sunday".equals(coMenu.getMenuWeek())) {
						sundayCoMenus.add(coMenu);
					}
				}
				List<CoMenuReqVo> coMenuReqVos = new ArrayList<CoMenuReqVo>();
				
				CoMenuReqVo coMenuReqVo = new CoMenuReqVo();
				List<CoMenuVo> coMenuVos = new ArrayList<CoMenuVo>();
				
				// 星期一
				for (CoMenu coMenu : mondayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("monday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				
				// 星期二
				coMenuReqVo = new CoMenuReqVo();
				coMenuVos = new ArrayList<CoMenuVo>();
				for (CoMenu coMenu : tuesdayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("tuesday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				
				// 星期三
				coMenuReqVo = new CoMenuReqVo();
				coMenuVos = new ArrayList<CoMenuVo>();
				for (CoMenu coMenu : wednesdayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("wednesday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				
				// 星期四
				coMenuReqVo = new CoMenuReqVo();
				coMenuVos = new ArrayList<CoMenuVo>();
				for (CoMenu coMenu : thursdayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("thursday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				
				// 星期五
				coMenuReqVo = new CoMenuReqVo();
				coMenuVos = new ArrayList<CoMenuVo>();
				for (CoMenu coMenu : fridayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("friday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				
				// 星期六
				coMenuReqVo = new CoMenuReqVo();
				coMenuVos = new ArrayList<CoMenuVo>();
				for (CoMenu coMenu : saturdayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("saturday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				
				// 星期日
				coMenuReqVo = new CoMenuReqVo();
				coMenuVos = new ArrayList<CoMenuVo>();
				for (CoMenu coMenu : sundayCoMenus) {
					CoMenuVo coMenuVo = new CoMenuVo();
					coMenuVo.setMenuMorningNoon(coMenu.getMenuMorningNoon());
					coMenuVo.setMenuContent(coMenu.getMenuContent());
					coMenuVo.setMenuGreetings(coMenu.getMenuGreetings());
					coMenuVo.setMenuFoodCulture(coMenu.getMenuFoodCulture());
					String itmeUrls = getItmeUrlsByItemName(coMenu.getMenuContent());
					coMenuVo.setItmeUrls(itmeUrls);
					coMenuVos.add(coMenuVo);
				}
				coMenuReqVo.setMenuWeek("sunday");
				coMenuReqVo.setCoMenuVos(coMenuVos);
				coMenuReqVos.add(coMenuReqVo);
				return AvailableResult.ok(coMenuReqVos);
			} else {
				return AvailableResult.ok("当前系统还未录入任何菜单，请现在开始录入吧！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return AvailableResult.errorException(e.getMessage());
		}
	}

	/**
	 * 通过菜单名称获取菜单图片url
	 * @param menuContent
	 * @return
	 */
	private String getItmeUrlsByItemName(String menuContent) {
		String[] strArr = menuContent.split(",");

		// 拼接url
		StringBuilder sb = new StringBuilder();
		for (String itemName : strArr) {
			CoMenuItem coMenuItem = new CoMenuItem();
			coMenuItem.setItemName(itemName);
			coMenuItem = coMenuItemMapper.selectOne(coMenuItem);
			if (coMenuItem != null) {
				if (!StringUtil.nullAndEmpty(coMenuItem.getItemUrl())) {
					sb.append(coMenuItem.getItemUrl()).append(",");
				}
			}
		}
		if (sb != null && !StringUtil.nullAndEmpty(sb.toString())) {
			return sb.toString().substring(0, sb.toString().length() - 1);
		} else {
			return null;
		}
	}

	/**
	 * 查询某个时间段的菜单信息
	 */
	@Override
	public AvailableResult queryCoMenuByKey(CoMenu coMenu) {
		try {
			if (coMenu == null) {
				return AvailableResult.errorMsg("请求参数为空");
			}
			if (StringUtil.nullAndEmpty(coMenu.getMenuWeek())) {
				return AvailableResult.errorMsg("请求参数的星期为空");
			}
			if (!"monday".equals(coMenu.getMenuWeek()) && !"tuesday".equals(coMenu.getMenuWeek())
					&& !"wednesday".equals(coMenu.getMenuWeek()) && !"thursday".equals(coMenu.getMenuWeek())
					&& !"friday".equals(coMenu.getMenuWeek()) && !"saturday".equals(coMenu.getMenuWeek())
					&& !"sunday".equals(coMenu.getMenuWeek())) {
				return AvailableResult.errorMsg("参数“星期”不符合规范，请检查");
			}
			if (StringUtil.nullAndEmpty(coMenu.getMenuMorningNoon())) {
				return AvailableResult.errorMsg("请求参数的时间段为空");
			}
			if (!"am".equals(coMenu.getMenuMorningNoon()) && !"pm".equals(coMenu.getMenuMorningNoon())) {
				return AvailableResult.errorMsg("参数“时间段”的值不符合规范，请检查");
			}
			List<CoMenu> list = coMenuMapper.select(coMenu);
			if (!list.isEmpty()) {
				CoMenu temp = list.get(0);
				String itemUrls = getItmeUrlsByItemName(temp.getMenuContent());
				temp.setExt1(itemUrls); // 此时ext1临时保存所有图片的url
				return AvailableResult.ok(temp);
			} else {
				return AvailableResult.ok("该时间段还未录入任何菜单内容，请现在录入吧！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return AvailableResult.errorException(e.getMessage());
		}
	}
}
