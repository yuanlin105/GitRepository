package com.gcb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.service.CoUserMenuService;

@RestController
@RequestMapping("/CoUserMenu")
public class CoUserMenuController {

	@Autowired
	private CoUserMenuService coUserMenuService;
}
