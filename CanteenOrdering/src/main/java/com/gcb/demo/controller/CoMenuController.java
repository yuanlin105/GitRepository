package com.gcb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoMenu;
import com.gcb.demo.service.CoMenuService;
import com.gcb.demo.vo.CoMenuReqEx;


@RestController
@RequestMapping("/CoMenu")
public class CoMenuController {
	
	@Autowired
	private CoMenuService coMenuService;
	
	@RequestMapping("/saveCoMenu")
	public AvailableResult saveCoMenu(@RequestBody CoMenuReqEx coMenuReqEx) {
		return coMenuService.saveCoMenu(coMenuReqEx);
	}
	
	@RequestMapping("/queryCoMenuList")
	public AvailableResult queryCoMenuList() throws Exception  {
		return coMenuService.queryCoMenuList();
	}
	
	@RequestMapping("/queryCoMenuByKey")
	public AvailableResult queryCoMenuByKey(@RequestBody CoMenu coMenu) throws Exception  {
		return coMenuService.queryCoMenuByKey(coMenu);
	}
}
