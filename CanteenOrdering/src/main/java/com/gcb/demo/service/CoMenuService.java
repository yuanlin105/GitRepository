package com.gcb.demo.service;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoMenu;
import com.gcb.demo.vo.CoMenuReqEx;

public interface CoMenuService {

	public AvailableResult queryCoMenuList();

	public AvailableResult saveCoMenu(CoMenuReqEx coMenuReqEx);

	public AvailableResult queryCoMenuByKey(CoMenu coMenu);

}
