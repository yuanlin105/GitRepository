package com.gcb.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcb.demo.dao.CoMenuItemMapper;
import com.gcb.demo.service.CoMenuItemService;

@Service
public class CoMenuItemServiceImpl implements CoMenuItemService{

	@Autowired
	private CoMenuItemMapper coMenuItemMapper;
}
