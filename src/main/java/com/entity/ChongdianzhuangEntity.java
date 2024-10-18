package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 充电桩
 *
 * @author 
 * @email
 */
@TableName("chongdianzhuang")
public class ChongdianzhuangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChongdianzhuangEntity() {

	}

	public ChongdianzhuangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 充电桩名称
     */
    @ColumnInfo(comment="充电桩名称",type="varchar(200)")
    @TableField(value = "chongdianzhuang_name")

    private String chongdianzhuangName;


    /**
     * 充电桩编号
     */
    @ColumnInfo(comment="充电桩编号",type="varchar(200)")
    @TableField(value = "chongdianzhuang_uuid_number")

    private String chongdianzhuangUuidNumber;


    /**
     * 充电桩照片
     */
    @ColumnInfo(comment="充电桩照片",type="varchar(200)")
    @TableField(value = "chongdianzhuang_photo")

    private String chongdianzhuangPhoto;


    /**
     * 充电桩类型
     */
    @ColumnInfo(comment="充电桩类型",type="int(11)")
    @TableField(value = "chongdianzhuang_types")

    private Integer chongdianzhuangTypes;


    /**
     * 充电桩状态
     */
    @ColumnInfo(comment="充电桩状态",type="int(11)")
    @TableField(value = "chongdianzhuang_zhuangtai_types")

    private Integer chongdianzhuangZhuangtaiTypes;


    /**
     * 可充时长
     */
    @ColumnInfo(comment="可充时长",type="int(11)")
    @TableField(value = "chongdianzhuang_kucun_number")

    private Integer chongdianzhuangKucunNumber;


    /**
     * 金额/小时
     */
    @ColumnInfo(comment="金额/小时",type="decimal(10,2)")
    @TableField(value = "chongdianzhuang_new_money")

    private Double chongdianzhuangNewMoney;


    /**
     * 充电桩介绍
     */
    @ColumnInfo(comment="充电桩介绍",type="text")
    @TableField(value = "chongdianzhuang_content")

    private String chongdianzhuangContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chongdianzhuang_delete")

    private Integer chongdianzhuangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：充电桩名称
	 */
    public String getChongdianzhuangName() {
        return chongdianzhuangName;
    }
    /**
	 * 设置：充电桩名称
	 */

    public void setChongdianzhuangName(String chongdianzhuangName) {
        this.chongdianzhuangName = chongdianzhuangName;
    }
    /**
	 * 获取：充电桩编号
	 */
    public String getChongdianzhuangUuidNumber() {
        return chongdianzhuangUuidNumber;
    }
    /**
	 * 设置：充电桩编号
	 */

    public void setChongdianzhuangUuidNumber(String chongdianzhuangUuidNumber) {
        this.chongdianzhuangUuidNumber = chongdianzhuangUuidNumber;
    }
    /**
	 * 获取：充电桩照片
	 */
    public String getChongdianzhuangPhoto() {
        return chongdianzhuangPhoto;
    }
    /**
	 * 设置：充电桩照片
	 */

    public void setChongdianzhuangPhoto(String chongdianzhuangPhoto) {
        this.chongdianzhuangPhoto = chongdianzhuangPhoto;
    }
    /**
	 * 获取：充电桩类型
	 */
    public Integer getChongdianzhuangTypes() {
        return chongdianzhuangTypes;
    }
    /**
	 * 设置：充电桩类型
	 */

    public void setChongdianzhuangTypes(Integer chongdianzhuangTypes) {
        this.chongdianzhuangTypes = chongdianzhuangTypes;
    }
    /**
	 * 获取：充电桩状态
	 */
    public Integer getChongdianzhuangZhuangtaiTypes() {
        return chongdianzhuangZhuangtaiTypes;
    }
    /**
	 * 设置：充电桩状态
	 */

    public void setChongdianzhuangZhuangtaiTypes(Integer chongdianzhuangZhuangtaiTypes) {
        this.chongdianzhuangZhuangtaiTypes = chongdianzhuangZhuangtaiTypes;
    }
    /**
	 * 获取：可充时长
	 */
    public Integer getChongdianzhuangKucunNumber() {
        return chongdianzhuangKucunNumber;
    }
    /**
	 * 设置：可充时长
	 */

    public void setChongdianzhuangKucunNumber(Integer chongdianzhuangKucunNumber) {
        this.chongdianzhuangKucunNumber = chongdianzhuangKucunNumber;
    }
    /**
	 * 获取：金额/小时
	 */
    public Double getChongdianzhuangNewMoney() {
        return chongdianzhuangNewMoney;
    }
    /**
	 * 设置：金额/小时
	 */

    public void setChongdianzhuangNewMoney(Double chongdianzhuangNewMoney) {
        this.chongdianzhuangNewMoney = chongdianzhuangNewMoney;
    }
    /**
	 * 获取：充电桩介绍
	 */
    public String getChongdianzhuangContent() {
        return chongdianzhuangContent;
    }
    /**
	 * 设置：充电桩介绍
	 */

    public void setChongdianzhuangContent(String chongdianzhuangContent) {
        this.chongdianzhuangContent = chongdianzhuangContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChongdianzhuangDelete() {
        return chongdianzhuangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChongdianzhuangDelete(Integer chongdianzhuangDelete) {
        this.chongdianzhuangDelete = chongdianzhuangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chongdianzhuang{" +
            ", id=" + id +
            ", chongdianzhuangName=" + chongdianzhuangName +
            ", chongdianzhuangUuidNumber=" + chongdianzhuangUuidNumber +
            ", chongdianzhuangPhoto=" + chongdianzhuangPhoto +
            ", chongdianzhuangTypes=" + chongdianzhuangTypes +
            ", chongdianzhuangZhuangtaiTypes=" + chongdianzhuangZhuangtaiTypes +
            ", chongdianzhuangKucunNumber=" + chongdianzhuangKucunNumber +
            ", chongdianzhuangNewMoney=" + chongdianzhuangNewMoney +
            ", chongdianzhuangContent=" + chongdianzhuangContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", chongdianzhuangDelete=" + chongdianzhuangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
