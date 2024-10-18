package com.entity.vo;

import com.entity.BaoxuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 反馈
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("baoxui")
public class BaoxuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 充电桩
     */

    @TableField(value = "chongdianzhuang_id")
    private Integer chongdianzhuangId;


    /**
     * 报修名称
     */

    @TableField(value = "baoxui_name")
    private String baoxuiName;


    /**
     * 报修图片
     */

    @TableField(value = "baoxui_photo")
    private String baoxuiPhoto;


    /**
     * 报修类型
     */

    @TableField(value = "baoxui_types")
    private Integer baoxuiTypes;


    /**
     * 申请反馈时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报修状态
     */

    @TableField(value = "baoxui_zhuangtai_types")
    private Integer baoxuiZhuangtaiTypes;


    /**
     * 报修详情
     */

    @TableField(value = "baoxui_content")
    private String baoxuiContent;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：充电桩
	 */
    public Integer getChongdianzhuangId() {
        return chongdianzhuangId;
    }


    /**
	 * 获取：充电桩
	 */

    public void setChongdianzhuangId(Integer chongdianzhuangId) {
        this.chongdianzhuangId = chongdianzhuangId;
    }
    /**
	 * 设置：报修名称
	 */
    public String getBaoxuiName() {
        return baoxuiName;
    }


    /**
	 * 获取：报修名称
	 */

    public void setBaoxuiName(String baoxuiName) {
        this.baoxuiName = baoxuiName;
    }
    /**
	 * 设置：报修图片
	 */
    public String getBaoxuiPhoto() {
        return baoxuiPhoto;
    }


    /**
	 * 获取：报修图片
	 */

    public void setBaoxuiPhoto(String baoxuiPhoto) {
        this.baoxuiPhoto = baoxuiPhoto;
    }
    /**
	 * 设置：报修类型
	 */
    public Integer getBaoxuiTypes() {
        return baoxuiTypes;
    }


    /**
	 * 获取：报修类型
	 */

    public void setBaoxuiTypes(Integer baoxuiTypes) {
        this.baoxuiTypes = baoxuiTypes;
    }
    /**
	 * 设置：申请反馈时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请反馈时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报修状态
	 */
    public Integer getBaoxuiZhuangtaiTypes() {
        return baoxuiZhuangtaiTypes;
    }


    /**
	 * 获取：报修状态
	 */

    public void setBaoxuiZhuangtaiTypes(Integer baoxuiZhuangtaiTypes) {
        this.baoxuiZhuangtaiTypes = baoxuiZhuangtaiTypes;
    }
    /**
	 * 设置：报修详情
	 */
    public String getBaoxuiContent() {
        return baoxuiContent;
    }


    /**
	 * 获取：报修详情
	 */

    public void setBaoxuiContent(String baoxuiContent) {
        this.baoxuiContent = baoxuiContent;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
