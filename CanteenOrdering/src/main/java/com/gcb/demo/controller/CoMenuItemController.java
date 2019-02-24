package com.gcb.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoMenuItem;
import com.gcb.demo.service.CoMenuItemService;

@RestController
@RequestMapping("/CoMenuItem")
public class CoMenuItemController {

	@Autowired
	private CoMenuItemService coMenuItemService;

	// 1，上传图片的接口
	@RequestMapping("fileUpload")
	public AvailableResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
		return coMenuItemService.fileUpload(file, request);
	}

	// 2，保存菜单单品的接口
	@RequestMapping("saveCoMenuItem")
	public AvailableResult saveCoMenuItem(@RequestBody CoMenuItem coMenuItem) {
		return coMenuItemService.saveCoMenuItem(coMenuItem);
	}
}
