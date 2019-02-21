package com.gcb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.service.CoMenuItemService;

@RestController
@RequestMapping("/CoMenuItem")
public class CoMenuItemController {

	@Autowired
	private CoMenuItemService coMenuItemService;
	
}
