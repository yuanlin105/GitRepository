package com.gcb.demo.vo;

import java.io.Serializable;
import java.util.List;

public class CoMenuReqVo implements Serializable{

	private static final long serialVersionUID = 1484025803012181116L;

	private String menuWeek; // 星期
	
	private List<CoMenuVo> coMenuVos; // 一个时间段的菜单

	public String getMenuWeek() {
		return menuWeek;
	}

	public void setMenuWeek(String menuWeek) {
		this.menuWeek = menuWeek;
	}

	public List<CoMenuVo> getCoMenuVos() {
		return coMenuVos;
	}

	public void setCoMenuVos(List<CoMenuVo> coMenuVos) {
		this.coMenuVos = coMenuVos;
	}
}
