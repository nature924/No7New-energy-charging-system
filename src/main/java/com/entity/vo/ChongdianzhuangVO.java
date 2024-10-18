package com.entity.vo;

import com.entity.ChongdianzhuangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 充电桩
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongdianzhuang")
public class ChongdianzhuangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 充电桩名称
     */

    @TableField(value = "chongdianzhuang_name")
    private String chongdianzhuangName;


    /**
     * 充电桩编号
     */

    @TableField(value = "chongdianzhuang_uuid_number")
    private String chongdianzhuangUuidNumber;


    /**
     * 充电桩照片
     */

    @TableField(value = "chongdianzhuang_photo")
    private String chongdianzhuangPhoto;


    /**
     * 充电桩类型
     */

    @TableField(value = "chongdianzhuang_types")
    private Integer chongdianzhuangTypes;


    /**
     * 充电桩状态
     */

    @TableField(value = "chongdianzhuang_zhuangtai_types")
    private Integer chongdianzhuangZhuangtaiTypes;


    /**
     * 可充时长
     */

    @TableField(value = "chongdianzhuang_kucun_number")
    private Integer chongdianzhuangKucunNumber;


    /**
     * 金额/小时
     */

    @TableField(value = "chongdianzhuang_new_money")
    private Double chongdianzhuangNewMoney;


    /**
     * 充电桩介绍
     */

    @TableField(value = "chongdianzhuang_content")
    private String chongdianzhuangContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "chongdianzhuang_delete")
    private Integer chongdianzhuangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：充电桩名称
	 */
    public String getChongdianzhuangName() {
        return chongdianzhuangName;
    }


    /**
	 * 获取：充电桩名称
	 */

    public void setChongdianzhuangName(String chongdianzhuangName) {
        this.chongdianzhuangName = chongdianzhuangName;
    }
    /**
	 * 设置：充电桩编号
	 */
    public String getChongdianzhuangUuidNumber() {
        return chongdianzhuangUuidNumber;
    }


    /**
	 * 获取：充电桩编号
	 */

    public void setChongdianzhuangUuidNumber(String chongdianzhuangUuidNumber) {
        this.chongdianzhuangUuidNumber = chongdianzhuangUuidNumber;
    }
    /**
	 * 设置：充电桩照片
	 */
    public String getChongdianzhuangPhoto() {
        return chongdianzhuangPhoto;
    }


    /**
	 * 获取：充电桩照片
	 */

    public void setChongdianzhuangPhoto(String chongdianzhuangPhoto) {
        this.chongdianzhuangPhoto = chongdianzhuangPhoto;
    }
    /**
	 * 设置：充电桩类型
	 */
    public Integer getChongdianzhuangTypes() {
        return chongdianzhuangTypes;
    }


    /**
	 * 获取：充电桩类型
	 */

    public void setChongdianzhuangTypes(Integer chongdianzhuangTypes) {
        this.chongdianzhuangTypes = chongdianzhuangTypes;
    }
    /**
	 * 设置：充电桩状态
	 */
    public Integer getChongdianzhuangZhuangtaiTypes() {
        return chongdianzhuangZhuangtaiTypes;
    }


    /**
	 * 获取：充电桩状态
	 */

    public void setChongdianzhuangZhuangtaiTypes(Integer chongdianzhuangZhuangtaiTypes) {
        this.chongdianzhuangZhuangtaiTypes = chongdianzhuangZhuangtaiTypes;
    }
    /**
	 * 设置：可充时长
	 */
    public Integer getChongdianzhuangKucunNumber() {
        return chongdianzhuangKucunNumber;
    }


    /**
	 * 获取：可充时长
	 */

    public void setChongdianzhuangKucunNumber(Integer chongdianzhuangKucunNumber) {
        this.chongdianzhuangKucunNumber = chongdianzhuangKucunNumber;
    }
    /**
	 * 设置：金额/小时
	 */
    public Double getChongdianzhuangNewMoney() {
        return chongdianzhuangNewMoney;
    }


    /**
	 * 获取：金额/小时
	 */

    public void setChongdianzhuangNewMoney(Double chongdianzhuangNewMoney) {
        this.chongdianzhuangNewMoney = chongdianzhuangNewMoney;
    }
    /**
	 * 设置：充电桩介绍
	 */
    public String getChongdianzhuangContent() {
        return chongdianzhuangContent;
    }


    /**
	 * 获取：充电桩介绍
	 */

    public void setChongdianzhuangContent(String chongdianzhuangContent) {
        this.chongdianzhuangContent = chongdianzhuangContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChongdianzhuangDelete() {
        return chongdianzhuangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChongdianzhuangDelete(Integer chongdianzhuangDelete) {
        this.chongdianzhuangDelete = chongdianzhuangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
