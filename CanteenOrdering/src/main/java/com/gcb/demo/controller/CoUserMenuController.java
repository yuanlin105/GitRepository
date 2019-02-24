package com.gcb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoUserMenu;
import com.gcb.demo.service.CoUserMenuService;

@RestController
@RequestMapping("/CoUserMenu")
public class CoUserMenuController {

	@Autowired
	private CoUserMenuService coUserMenuService;
	
	@RequestMapping("/saveCoUserMenuRelation")
	public AvailableResult saveCoUserMenuRelation(@RequestBody CoUserMenu coUserMenu) {
		return coUserMenuService.saveCoUserMenuRelation(coUserMenu);
	}
	
	@RequestMapping("/findCoUserMenuRelation")
	public AvailableResult findCoUserMenuRelation(@RequestBody CoUserMenu coUserMenu) {
		return coUserMenuService.findCoUserMenuRelation(coUserMenu);
	}
}
