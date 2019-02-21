package com.gcb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcb.demo.dao.CoUserMapper;
import com.gcb.demo.service.CoUserService;

@Service
public class CoUserServiceImpl implements CoUserService{

	@Autowired
	private CoUserMapper coUserMapper;
}
