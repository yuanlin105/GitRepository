package com.gcb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.po.CoMenu;
import com.gcb.demo.service.CoMenuService;


@RestController
@RequestMapping("/CoMenu")
public class CoMenuController {
	
	@Autowired
	private CoMenuService coMenuService;
	

	@RequestMapping("/queryCoMenuList")
	public List<CoMenu> queryCoMenuList() {
		return coMenuService.queryCoMenuList();
	}
}
