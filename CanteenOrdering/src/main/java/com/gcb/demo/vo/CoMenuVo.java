package com.gcb.demo.vo;

import java.io.Serializable;

public class CoMenuVo implements Serializable{

	private static final long serialVersionUID = 8517979053646132077L;

	/**
     * 上午/中午
     */
    private String menuMorningNoon;

    /**
     * 菜单内容（多个单品用英文逗号分隔）
     */
    private String menuContent;

    /**
     * 菜单单品图片所有url，用英文逗号分隔
     */
    private String itmeUrls;
    
    /**
     * 祝福语
     */
    private String menuGreetings;

    /**
     * 饮食文化
     */
    private String menuFoodCulture;
    

	public String getMenuMorningNoon() {
		return menuMorningNoon;
	}

	public void setMenuMorningNoon(String menuMorningNoon) {
		this.menuMorningNoon = menuMorningNoon;
	}

	public String getMenuContent() {
		return menuContent;
	}

	public void setMenuContent(String menuContent) {
		this.menuContent = menuContent;
	}

	public String getMenuGreetings() {
		return menuGreetings;
	}

	public void setMenuGreetings(String menuGreetings) {
		this.menuGreetings = menuGreetings;
	}

	public String getMenuFoodCulture() {
		return menuFoodCulture;
	}

	public void setMenuFoodCulture(String menuFoodCulture) {
		this.menuFoodCulture = menuFoodCulture;
	}

	public String getItmeUrls() {
		return itmeUrls;
	}

	public void setItmeUrls(String itmeUrls) {
		this.itmeUrls = itmeUrls;
	}
}