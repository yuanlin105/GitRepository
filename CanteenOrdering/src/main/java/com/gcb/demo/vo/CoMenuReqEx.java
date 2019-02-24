package com.gcb.demo.vo;

import java.io.Serializable;
import java.util.List;

public class CoMenuReqEx implements Serializable{

	private static final long serialVersionUID = -5257896317443501676L;

	private List<CoMenuReqVo> list;

	public List<CoMenuReqVo> getList() {
		return list;
	}

	public void setList(List<CoMenuReqVo> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CoMenuReqEx [list=" + list + "]";
	}
}
