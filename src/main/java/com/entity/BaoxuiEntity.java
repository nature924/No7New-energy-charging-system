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
 * 反馈
 *
 * @author 
 * @email
 */
@TableName("baoxui")
public class BaoxuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxuiEntity() {

	}

	public BaoxuiEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 充电桩
     */
    @ColumnInfo(comment="充电桩",type="int(11)")
    @TableField(value = "chongdianzhuang_id")

    private Integer chongdianzhuangId;


    /**
     * 报修名称
     */
    @ColumnInfo(comment="报修名称",type="varchar(200)")
    @TableField(value = "baoxui_name")

    private String baoxuiName;


    /**
     * 报修图片
     */
    @ColumnInfo(comment="报修图片",type="varchar(200)")
    @TableField(value = "baoxui_photo")

    private String baoxuiPhoto;


    /**
     * 报修类型
     */
    @ColumnInfo(comment="报修类型",type="int(11)")
    @TableField(value = "baoxui_types")

    private Integer baoxuiTypes;


    /**
     * 申请反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请反馈时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报修状态
     */
    @ColumnInfo(comment="报修状态",type="int(11)")
    @TableField(value = "baoxui_zhuangtai_types")

    private Integer baoxuiZhuangtaiTypes;


    /**
     * 报修详情
     */
    @ColumnInfo(comment="报修详情",type="text")
    @TableField(value = "baoxui_content")

    private String baoxuiContent;


    /**
     * 创建时间  listShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：充电桩
	 */
    public Integer getChongdianzhuangId() {
        return chongdianzhuangId;
    }
    /**
	 * 设置：充电桩
	 */

    public void setChongdianzhuangId(Integer chongdianzhuangId) {
        this.chongdianzhuangId = chongdianzhuangId;
    }
    /**
	 * 获取：报修名称
	 */
    public String getBaoxuiName() {
        return baoxuiName;
    }
    /**
	 * 设置：报修名称
	 */

    public void setBaoxuiName(String baoxuiName) {
        this.baoxuiName = baoxuiName;
    }
    /**
	 * 获取：报修图片
	 */
    public String getBaoxuiPhoto() {
        return baoxuiPhoto;
    }
    /**
	 * 设置：报修图片
	 */

    public void setBaoxuiPhoto(String baoxuiPhoto) {
        this.baoxuiPhoto = baoxuiPhoto;
    }
    /**
	 * 获取：报修类型
	 */
    public Integer getBaoxuiTypes() {
        return baoxuiTypes;
    }
    /**
	 * 设置：报修类型
	 */

    public void setBaoxuiTypes(Integer baoxuiTypes) {
        this.baoxuiTypes = baoxuiTypes;
    }
    /**
	 * 获取：申请反馈时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请反馈时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报修状态
	 */
    public Integer getBaoxuiZhuangtaiTypes() {
        return baoxuiZhuangtaiTypes;
    }
    /**
	 * 设置：报修状态
	 */

    public void setBaoxuiZhuangtaiTypes(Integer baoxuiZhuangtaiTypes) {
        this.baoxuiZhuangtaiTypes = baoxuiZhuangtaiTypes;
    }
    /**
	 * 获取：报修详情
	 */
    public String getBaoxuiContent() {
        return baoxuiContent;
    }
    /**
	 * 设置：报修详情
	 */

    public void setBaoxuiContent(String baoxuiContent) {
        this.baoxuiContent = baoxuiContent;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Baoxui{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", chongdianzhuangId=" + chongdianzhuangId +
            ", baoxuiName=" + baoxuiName +
            ", baoxuiPhoto=" + baoxuiPhoto +
            ", baoxuiTypes=" + baoxuiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", baoxuiZhuangtaiTypes=" + baoxuiZhuangtaiTypes +
            ", baoxuiContent=" + baoxuiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
