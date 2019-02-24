package com.gcb.demo.utils;

public class StringUtil {

	public static boolean nullAndEmpty(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		}
		return false;
	}
}
