package com.gcb.demo.po;

import javax.persistence.*;

@Table(name = "co_user_menu")
public class CoUserMenu {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 星期几（周一到周天）
     */
    @Id
    @Column(name = "menu_week")
    private String menuWeek;

    /**
     * 上午/下午
     */
    @Id
    @Column(name = "menu_morning_noon")
    private String menuMorningNoon;

    /**
     * 状态：1-没想好，2-我要吃，3-不想吃
     */
    private String status;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取星期几（周一到周天）
     *
     * @return menu_week - 星期几（周一到周天）
     */
    public String getMenuWeek() {
        return menuWeek;
    }

    /**
     * 设置星期几（周一到周天）
     *
     * @param menuWeek 星期几（周一到周天）
     */
    public void setMenuWeek(String menuWeek) {
        this.menuWeek = menuWeek;
    }

    /**
     * 获取上午/下午
     *
     * @return menu_morning_noon - 上午/下午
     */
    public String getMenuMorningNoon() {
        return menuMorningNoon;
    }

    /**
     * 设置上午/下午
     *
     * @param menuMorningNoon 上午/下午
     */
    public void setMenuMorningNoon(String menuMorningNoon) {
        this.menuMorningNoon = menuMorningNoon;
    }

    /**
     * 获取状态：1-没想好，2-我要吃，3-不想吃
     *
     * @return status - 状态：1-没想好，2-我要吃，3-不想吃
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态：1-没想好，2-我要吃，3-不想吃
     *
     * @param status 状态：1-没想好，2-我要吃，3-不想吃
     */
    public void setStatus(String status) {
        this.status = status;
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