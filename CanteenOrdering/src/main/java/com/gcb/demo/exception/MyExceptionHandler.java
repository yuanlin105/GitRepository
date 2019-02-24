package com.gcb.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gcb.demo.po.AvailableResult;


@ControllerAdvice
public class MyExceptionHandler {

	public static final String MY_ERROR_VIEW = "error";
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	if (isAjax(reqest)) {
    		return AvailableResult.errorException(e.getMessage());
    	} else {
            Map map = new HashMap();
            map.put("msg", e.getMessage());
            map.put("url", reqest.getRequestURL());
            return map;
    	}
    }
	
	/**
	 * @Description: 判断是否是ajax请求
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}
}
