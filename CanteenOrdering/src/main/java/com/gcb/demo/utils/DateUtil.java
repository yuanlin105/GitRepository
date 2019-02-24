package com.gcb.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	
	public static String getCurrentTime() {
		String date = df.format(new Date());
		return date;
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.getCurrentTime());
	}
}
