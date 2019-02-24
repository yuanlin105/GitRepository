package com.gcb.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcb.demo.dao.CoUserMapper;
import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoUser;
import com.gcb.demo.service.CoUserService;
import com.gcb.demo.utils.StringUtil;

@Service
public class CoUserServiceImpl implements CoUserService{

	Logger logger = LoggerFactory.getLogger(CoUserServiceImpl.class);
	
	@Autowired
	private CoUserMapper coUserMapper;

	@Override
	public AvailableResult saveCoUser(CoUser coUser) {
		try {
			if (coUser == null) {
				return AvailableResult.errorMsg("请求参数为空");
			}
			if (StringUtil.nullAndEmpty(coUser.getUserId())) {
				return AvailableResult.errorMsg("请求参数的用户id为空");
			}
			if (StringUtil.nullAndEmpty(coUser.getUserName())) {
				return AvailableResult.errorMsg("请求参数的姓名为空");
			}
			coUserMapper.insert(coUser);
			return AvailableResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return AvailableResult.errorException(e.getMessage());
		}
	}
}
