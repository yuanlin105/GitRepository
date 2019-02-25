package com.gcb.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcb.demo.dao.CoUserMenuMapper;
import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoUserMenu;
import com.gcb.demo.service.CoUserMenuService;
import com.gcb.demo.utils.DateUtil;
import com.gcb.demo.utils.StringUtil;

@Service
public class CoUserMenuServiceImpl implements CoUserMenuService{

	Logger logger = LoggerFactory.getLogger(CoUserMenuServiceImpl.class);
	
	@Autowired
	private CoUserMenuMapper coUserMenuMapper;

	@Override
	public AvailableResult saveCoUserMenuRelation(CoUserMenu coUserMenu) {
		try {
			logger.info(">>>>>>>>>>开始保存用户和菜单的关系>>>>>>>>>>");
			if (coUserMenu == null) {
				return AvailableResult.errorMsg("请求参数为空");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getUserId())) {
				return AvailableResult.errorMsg("请求参数的用户id为空");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getStatus())) {
				return AvailableResult.errorMsg("请求参数的状态为空");
			}
			if (!"1".equals(coUserMenu.getStatus()) && !"2".equals(coUserMenu.getStatus()) && !"3".equals(coUserMenu.getStatus())) {
				return AvailableResult.errorMsg("参数“状态”的值不符合规范，请检查");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getMenuWeek())) {
				return AvailableResult.errorMsg("请求参数的星期为空");
			}
			if (!"monday".equals(coUserMenu.getMenuWeek()) && !"tuesday".equals(coUserMenu.getMenuWeek())
					&& !"wednesday".equals(coUserMenu.getMenuWeek()) && !"thursday".equals(coUserMenu.getMenuWeek())
					&& !"friday".equals(coUserMenu.getMenuWeek()) && !"saturday".equals(coUserMenu.getMenuWeek())
					&& !"sunday".equals(coUserMenu.getMenuWeek())) {
				return AvailableResult.errorMsg("参数“星期”不符合规范，请检查");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getMenuMorningNoon())) {
				return AvailableResult.errorMsg("请求参数的时间段为空");
			}
			if (!"am".equals(coUserMenu.getMenuMorningNoon()) && !"pm".equals(coUserMenu.getMenuMorningNoon())) {
				return AvailableResult.errorMsg("参数“时间段”的值不符合规范，请检查");
			}
			
			logger.info(">>>>>>>>>>请求参数=" + coUserMenu.toString());
			
			coUserMenu.setUpdateTime(DateUtil.getCurrentTime());
			
			CoUserMenu cMenu = new CoUserMenu();
			cMenu.setUserId(coUserMenu.getUserId());
			cMenu.setMenuWeek(coUserMenu.getMenuWeek());
			cMenu.setMenuMorningNoon(coUserMenu.getMenuMorningNoon());
			List<CoUserMenu> list = coUserMenuMapper.select(cMenu);
			if (list.isEmpty()) {
				coUserMenuMapper.insert(coUserMenu);
			} else {
				coUserMenuMapper.updateByPrimaryKeySelective(coUserMenu);
			}
			logger.info(">>>>>>>>>>结束保存用户和菜单的关系>>>>>>>>>>");
			return AvailableResult.ok();
		} catch (Exception e) {
			logger.error(">>>>>>>>>>保存用户和菜单的关系出现异常，原因为：" + e.getMessage());
			e.printStackTrace();
			return AvailableResult.errorException(e.getMessage());
		}
	}

	@Override
	public AvailableResult findCoUserMenuRelation(CoUserMenu coUserMenu) {
		try {
			logger.info(">>>>>>>>>>开始查询用户和菜单的关系>>>>>>>>>>");
			if (coUserMenu == null) {
				return AvailableResult.errorMsg("请求参数为空");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getUserId())) {
				return AvailableResult.errorMsg("请求参数的用户id为空");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getMenuWeek())) {
				return AvailableResult.errorMsg("请求参数的星期为空");
			}
			if (!"monday".equals(coUserMenu.getMenuWeek()) && !"tuesday".equals(coUserMenu.getMenuWeek())
					&& !"wednesday".equals(coUserMenu.getMenuWeek()) && !"thursday".equals(coUserMenu.getMenuWeek())
					&& !"friday".equals(coUserMenu.getMenuWeek()) && !"saturday".equals(coUserMenu.getMenuWeek())
					&& !"sunday".equals(coUserMenu.getMenuWeek())) {
				return AvailableResult.errorMsg("参数“星期”不符合规范，请检查");
			}
			if (StringUtil.nullAndEmpty(coUserMenu.getMenuMorningNoon())) {
				return AvailableResult.errorMsg("请求参数的时间段为空");
			}
			if (!"am".equals(coUserMenu.getMenuMorningNoon()) && !"pm".equals(coUserMenu.getMenuMorningNoon())) {
				return AvailableResult.errorMsg("参数“时间段”的值不符合规范，请检查");
			}
			logger.info(">>>>>>>>>>请求参数=" + coUserMenu.toString());
			coUserMenu = coUserMenuMapper.selectOne(coUserMenu);
			logger.info(">>>>>>>>>>开始查询用户和菜单的关系>>>>>>>>>>");
			return AvailableResult.ok(coUserMenu);
		} catch (Exception e) {
			logger.error(">>>>>>>>>>查询用户和菜单的关系出现异常，原因为：" + e.getMessage());
			e.printStackTrace();
			return AvailableResult.errorException(e.getMessage());
		}
	}
}
