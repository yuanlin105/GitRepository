package com.gcb.demo.po;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "co_menu")
public class CoMenu implements Serializable{

	private static final long serialVersionUID = 7478020758969043949L;

	/**
     * 星期几（周一到周日）
     */
    @Id
    @Column(name = "menu_week")
    private String menuWeek;

    /**
     * 上午/中午
     */
    @Id
    @Column(name = "menu_morning_noon")
    private String menuMorningNoon;

    /**
     * 菜单内容（多个单品用英文逗号分隔）
     */
    @Column(name = "menu_content")
    private String menuContent;

    /**
     * 祝福语
     */
    @Column(name = "menu_greetings")
    private String menuGreetings;

    /**
     * 饮食文化
     */
    @Column(name = "menu_food_culture")
    private String menuFoodCulture;

    /**
     * 更新时间,时间格式：yyyy-MM-dd HH:mm:ss
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 扩展字段1
     */
    private String ext1;

    /**
     * 扩展字段2
     */
    private String ext2;

    /**
     * 扩展字段3
     */
    private String ext3;

    /**
     * 获取星期几（周一到周日）
     *
     * @return menu_week - 星期几（周一到周日）
     */
    public String getMenuWeek() {
        return menuWeek;
    }

    /**
     * 设置星期几（周一到周日）
     *
     * @param menuWeek 星期几（周一到周日）
     */
    public void setMenuWeek(String menuWeek) {
        this.menuWeek = menuWeek;
    }

    /**
     * 获取上午/中午
     *
     * @return menu_morning_noon - 上午/中午
     */
    public String getMenuMorningNoon() {
        return menuMorningNoon;
    }

    /**
     * 设置上午/中午
     *
     * @param menuMorningNoon 上午/中午
     */
    public void setMenuMorningNoon(String menuMorningNoon) {
        this.menuMorningNoon = menuMorningNoon;
    }

    /**
     * 获取菜单内容（多个单品用英文逗号分隔）
     *
     * @return menu_content - 菜单内容（多个单品用英文逗号分隔）
     */
    public String getMenuContent() {
        return menuContent;
    }

    /**
     * 设置菜单内容（多个单品用英文逗号分隔）
     *
     * @param menuContent 菜单内容（多个单品用英文逗号分隔）
     */
    public void setMenuContent(String menuContent) {
        this.menuContent = menuContent;
    }

    /**
     * 获取祝福语
     *
     * @return menu_greetings - 祝福语
     */
    public String getMenuGreetings() {
        return menuGreetings;
    }

    /**
     * 设置祝福语
     *
     * @param menuGreetings 祝福语
     */
    public void setMenuGreetings(String menuGreetings) {
        this.menuGreetings = menuGreetings;
    }

    /**
     * 获取饮食文化
     *
     * @return menu_food_culture - 饮食文化
     */
    public String getMenuFoodCulture() {
        return menuFoodCulture;
    }

    /**
     * 设置饮食文化
     *
     * @param menuFoodCulture 饮食文化
     */
    public void setMenuFoodCulture(String menuFoodCulture) {
        this.menuFoodCulture = menuFoodCulture;
    }

    /**
     * 获取更新时间,时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @return update_time - 更新时间,时间格式：yyyy-MM-dd HH:mm:ss
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间,时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @param updateTime 更新时间,时间格式：yyyy-MM-dd HH:mm:ss
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取扩展字段1
     *
     * @return ext1 - 扩展字段1
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置扩展字段1
     *
     * @param ext1 扩展字段1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    /**
     * 获取扩展字段2
     *
     * @return ext2 - 扩展字段2
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置扩展字段2
     *
     * @param ext2 扩展字段2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    /**
     * 获取扩展字段3
     *
     * @return ext3 - 扩展字段3
     */
    public String getExt3() {
        return ext3;
    }

    /**
     * 设置扩展字段3
     *
     * @param ext3 扩展字段3
     */
    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }
}