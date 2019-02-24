package com.gcb.demo.service;

import com.gcb.demo.po.AvailableResult;
import com.gcb.demo.po.CoUserMenu;

public interface CoUserMenuService {

	AvailableResult saveCoUserMenuRelation(CoUserMenu coUserMenu);

	AvailableResult findCoUserMenuRelation(CoUserMenu coUserMenu);
}
