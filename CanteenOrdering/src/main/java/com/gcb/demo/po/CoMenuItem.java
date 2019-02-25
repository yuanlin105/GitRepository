package com.gcb.demo.po;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "co_menu_item")
public class CoMenuItem implements Serializable{

	private static final long serialVersionUID = -6813472897680459784L;

	/**
     * 单品id
     */
    @Id
    @Column(name = "item_id")
    private String itemId;

    /**
     * 单品名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 单品图片的url
     */
    @Column(name = "item_url")
    private String itemUrl;

    /**
     * 创建时间,时间格式：yyyy-MM-dd HH:mm:ss
     */
    @Column(name = "create_time")
    private String createTime;

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
     * 获取单品id
     *
     * @return item_id - 单品id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置单品id
     *
     * @param itemId 单品id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取单品名称
     *
     * @return item_name - 单品名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置单品名称
     *
     * @param itemName 单品名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取单品图片的url
     *
     * @return item_url - 单品图片的url
     */
    public String getItemUrl() {
        return itemUrl;
    }

    /**
     * 设置单品图片的url
     *
     * @param itemUrl 单品图片的url
     */
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    /**
     * 获取创建时间,时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @return create_time - 创建时间,时间格式：yyyy-MM-dd HH:mm:ss
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间,时间格式：yyyy-MM-dd HH:mm:ss
     *
     * @param createTime 创建时间,时间格式：yyyy-MM-dd HH:mm:ss
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

	@Override
	public String toString() {
		return "CoMenuItem [itemId=" + itemId + ", itemName=" + itemName + ", itemUrl=" + itemUrl + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", ext1=" + ext1 + ", ext2=" + ext2 + ", ext3=" + ext3
				+ "]";
	}
}