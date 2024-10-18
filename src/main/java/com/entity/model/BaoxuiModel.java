package com.entity.model;

import com.entity.BaoxuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 反馈
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BaoxuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 充电桩
     */
    private Integer chongdianzhuangId;


    /**
     * 报修名称
     */
    private String baoxuiName;


    /**
     * 报修图片
     */
    private String baoxuiPhoto;


    /**
     * 报修类型
     */
    private Integer baoxuiTypes;


    /**
     * 申请反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报修状态
     */
    private Integer baoxuiZhuangtaiTypes;


    /**
     * 报修详情
     */
    private String baoxuiContent;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
