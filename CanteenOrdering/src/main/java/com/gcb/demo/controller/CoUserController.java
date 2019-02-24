package com.gcb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoUser;
import com.gcb.demo.service.CoUserService;

@RestController
@RequestMapping("/CoUser")
public class CoUserController {

	@Autowired
	private CoUserService coUserService;
	
	@RequestMapping("/saveCoUser")
	public AvailableResult saveCoUser(@RequestBody CoUser coUser) {
		return coUserService.saveCoUser(coUser);
	}
}
