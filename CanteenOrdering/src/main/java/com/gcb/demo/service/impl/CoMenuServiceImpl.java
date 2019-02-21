package com.gcb.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gcb.demo.dao.CoMenuMapper;
import com.gcb.demo.po.CoMenu;
import com.gcb.demo.service.CoMenuService;

@Service
public class CoMenuServiceImpl implements CoMenuService{

	@Autowired
	private CoMenuMapper coMenuMapper;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<CoMenu> queryCoMenuList() {
		return coMenuMapper.selectAll();
	}
}
