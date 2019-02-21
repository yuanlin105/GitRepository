package com.gcb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcb.demo.dao.CoUserMenuMapper;
import com.gcb.demo.service.CoUserMenuService;

@Service
public class CoUserMenuServiceImpl implements CoUserMenuService{

	@Autowired
	private CoUserMenuMapper coUserMenuMapper;
}
