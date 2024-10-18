package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChongdianzhuangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 充电桩
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chongdianzhuang")
public class ChongdianzhuangView extends ChongdianzhuangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 充电桩类型的值
	*/
	@ColumnInfo(comment="充电桩类型的字典表值",type="varchar(200)")
	private String chongdianzhuangValue;
	/**
	* 充电桩状态的值
	*/
	@ColumnInfo(comment="充电桩状态的字典表值",type="varchar(200)")
	private String chongdianzhuangZhuangtaiValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public ChongdianzhuangView() {

	}

	public ChongdianzhuangView(ChongdianzhuangEntity chongdianzhuangEntity) {
		try {
			BeanUtils.copyProperties(this, chongdianzhuangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 充电桩类型的值
	*/
	public String getChongdianzhuangValue() {
		return chongdianzhuangValue;
	}
	/**
	* 设置： 充电桩类型的值
	*/
	public void setChongdianzhuangValue(String chongdianzhuangValue) {
		this.chongdianzhuangValue = chongdianzhuangValue;
	}
	//当前表的
	/**
	* 获取： 充电桩状态的值
	*/
	public String getChongdianzhuangZhuangtaiValue() {
		return chongdianzhuangZhuangtaiValue;
	}
	/**
	* 设置： 充电桩状态的值
	*/
	public void setChongdianzhuangZhuangtaiValue(String chongdianzhuangZhuangtaiValue) {
		this.chongdianzhuangZhuangtaiValue = chongdianzhuangZhuangtaiValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "ChongdianzhuangView{" +
			", chongdianzhuangValue=" + chongdianzhuangValue +
			", chongdianzhuangZhuangtaiValue=" + chongdianzhuangZhuangtaiValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
