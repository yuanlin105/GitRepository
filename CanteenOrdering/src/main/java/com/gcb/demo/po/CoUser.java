package com.gcb.demo.po;

import javax.persistence.*;

@Table(name = "co_user")
public class CoUser {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户年龄
     */
    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 用户性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 用户联系方式
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户地址
     */
    @Column(name = "user_address")
    private String userAddress;

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
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取用户年龄
     *
     * @return user_age - 用户年龄
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * 设置用户年龄
     *
     * @param userAge 用户年龄
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取用户性别
     *
     * @return user_sex - 用户性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取用户联系方式
     *
     * @return user_phone - 用户联系方式
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户联系方式
     *
     * @param userPhone 用户联系方式
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取用户地址
     *
     * @return user_address - 用户地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置用户地址
     *
     * @param userAddress 用户地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
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