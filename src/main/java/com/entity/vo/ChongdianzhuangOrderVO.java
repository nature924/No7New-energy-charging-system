package com.entity.vo;

import com.entity.ChongdianzhuangOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 充电桩预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chongdianzhuang_order")
public class ChongdianzhuangOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 充电桩
     */

    @TableField(value = "chongdianzhuang_id")
    private Integer chongdianzhuangId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 充电小时
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chongdianzhuang_order_time")
    private Date chongdianzhuangOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "chongdianzhuang_order_true_price")
    private Double chongdianzhuangOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "chongdianzhuang_order_types")
    private Integer chongdianzhuangOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：充电小时
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：充电小时
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getChongdianzhuangOrderTime() {
        return chongdianzhuangOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setChongdianzhuangOrderTime(Date chongdianzhuangOrderTime) {
        this.chongdianzhuangOrderTime = chongdianzhuangOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getChongdianzhuangOrderTruePrice() {
        return chongdianzhuangOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setChongdianzhuangOrderTruePrice(Double chongdianzhuangOrderTruePrice) {
        this.chongdianzhuangOrderTruePrice = chongdianzhuangOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getChongdianzhuangOrderTypes() {
        return chongdianzhuangOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setChongdianzhuangOrderTypes(Integer chongdianzhuangOrderTypes) {
        this.chongdianzhuangOrderTypes = chongdianzhuangOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
