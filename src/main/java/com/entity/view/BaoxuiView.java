package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BaoxuiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 反馈
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("baoxui")
public class BaoxuiView extends BaoxuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报修类型的值
	*/
	@ColumnInfo(comment="报修类型的字典表值",type="varchar(200)")
	private String baoxuiValue;
	/**
	* 报修状态的值
	*/
	@ColumnInfo(comment="报修状态的字典表值",type="varchar(200)")
	private String baoxuiZhuangtaiValue;

	//级联表 充电桩
		/**
		* 充电桩名称
		*/

		@ColumnInfo(comment="充电桩名称",type="varchar(200)")
		private String chongdianzhuangName;
		/**
		* 充电桩编号
		*/

		@ColumnInfo(comment="充电桩编号",type="varchar(200)")
		private String chongdianzhuangUuidNumber;
		/**
		* 充电桩照片
		*/

		@ColumnInfo(comment="充电桩照片",type="varchar(200)")
		private String chongdianzhuangPhoto;
		/**
		* 充电桩类型
		*/
		@ColumnInfo(comment="充电桩类型",type="int(11)")
		private Integer chongdianzhuangTypes;
			/**
			* 充电桩类型的值
			*/
			@ColumnInfo(comment="充电桩类型的字典表值",type="varchar(200)")
			private String chongdianzhuangValue;
		/**
		* 充电桩状态
		*/
		@ColumnInfo(comment="充电桩状态",type="int(11)")
		private Integer chongdianzhuangZhuangtaiTypes;
			/**
			* 充电桩状态的值
			*/
			@ColumnInfo(comment="充电桩状态的字典表值",type="varchar(200)")
			private String chongdianzhuangZhuangtaiValue;
		/**
		* 可充时长
		*/

		@ColumnInfo(comment="可充时长",type="int(11)")
		private Integer chongdianzhuangKucunNumber;
		/**
		* 金额/小时
		*/
		@ColumnInfo(comment="金额/小时",type="decimal(10,2)")
		private Double chongdianzhuangNewMoney;
		/**
		* 充电桩介绍
		*/

		@ColumnInfo(comment="充电桩介绍",type="text")
		private String chongdianzhuangContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer chongdianzhuangDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public BaoxuiView() {

	}

	public BaoxuiView(BaoxuiEntity baoxuiEntity) {
		try {
			BeanUtils.copyProperties(this, baoxuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报修类型的值
	*/
	public String getBaoxuiValue() {
		return baoxuiValue;
	}
	/**
	* 设置： 报修类型的值
	*/
	public void setBaoxuiValue(String baoxuiValue) {
		this.baoxuiValue = baoxuiValue;
	}
	//当前表的
	/**
	* 获取： 报修状态的值
	*/
	public String getBaoxuiZhuangtaiValue() {
		return baoxuiZhuangtaiValue;
	}
	/**
	* 设置： 报修状态的值
	*/
	public void setBaoxuiZhuangtaiValue(String baoxuiZhuangtaiValue) {
		this.baoxuiZhuangtaiValue = baoxuiZhuangtaiValue;
	}


	//级联表的get和set 充电桩

		/**
		* 获取： 充电桩名称
		*/
		public String getChongdianzhuangName() {
			return chongdianzhuangName;
		}
		/**
		* 设置： 充电桩名称
		*/
		public void setChongdianzhuangName(String chongdianzhuangName) {
			this.chongdianzhuangName = chongdianzhuangName;
		}

		/**
		* 获取： 充电桩编号
		*/
		public String getChongdianzhuangUuidNumber() {
			return chongdianzhuangUuidNumber;
		}
		/**
		* 设置： 充电桩编号
		*/
		public void setChongdianzhuangUuidNumber(String chongdianzhuangUuidNumber) {
			this.chongdianzhuangUuidNumber = chongdianzhuangUuidNumber;
		}

		/**
		* 获取： 充电桩照片
		*/
		public String getChongdianzhuangPhoto() {
			return chongdianzhuangPhoto;
		}
		/**
		* 设置： 充电桩照片
		*/
		public void setChongdianzhuangPhoto(String chongdianzhuangPhoto) {
			this.chongdianzhuangPhoto = chongdianzhuangPhoto;
		}
		/**
		* 获取： 充电桩类型
		*/
		public Integer getChongdianzhuangTypes() {
			return chongdianzhuangTypes;
		}
		/**
		* 设置： 充电桩类型
		*/
		public void setChongdianzhuangTypes(Integer chongdianzhuangTypes) {
			this.chongdianzhuangTypes = chongdianzhuangTypes;
		}


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
		/**
		* 获取： 充电桩状态
		*/
		public Integer getChongdianzhuangZhuangtaiTypes() {
			return chongdianzhuangZhuangtaiTypes;
		}
		/**
		* 设置： 充电桩状态
		*/
		public void setChongdianzhuangZhuangtaiTypes(Integer chongdianzhuangZhuangtaiTypes) {
			this.chongdianzhuangZhuangtaiTypes = chongdianzhuangZhuangtaiTypes;
		}


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

		/**
		* 获取： 可充时长
		*/
		public Integer getChongdianzhuangKucunNumber() {
			return chongdianzhuangKucunNumber;
		}
		/**
		* 设置： 可充时长
		*/
		public void setChongdianzhuangKucunNumber(Integer chongdianzhuangKucunNumber) {
			this.chongdianzhuangKucunNumber = chongdianzhuangKucunNumber;
		}

		/**
		* 获取： 金额/小时
		*/
		public Double getChongdianzhuangNewMoney() {
			return chongdianzhuangNewMoney;
		}
		/**
		* 设置： 金额/小时
		*/
		public void setChongdianzhuangNewMoney(Double chongdianzhuangNewMoney) {
			this.chongdianzhuangNewMoney = chongdianzhuangNewMoney;
		}

		/**
		* 获取： 充电桩介绍
		*/
		public String getChongdianzhuangContent() {
			return chongdianzhuangContent;
		}
		/**
		* 设置： 充电桩介绍
		*/
		public void setChongdianzhuangContent(String chongdianzhuangContent) {
			this.chongdianzhuangContent = chongdianzhuangContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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

		/**
		* 获取： 逻辑删除
		*/
		public Integer getChongdianzhuangDelete() {
			return chongdianzhuangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setChongdianzhuangDelete(Integer chongdianzhuangDelete) {
			this.chongdianzhuangDelete = chongdianzhuangDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "BaoxuiView{" +
			", baoxuiValue=" + baoxuiValue +
			", baoxuiZhuangtaiValue=" + baoxuiZhuangtaiValue +
			", chongdianzhuangName=" + chongdianzhuangName +
			", chongdianzhuangUuidNumber=" + chongdianzhuangUuidNumber +
			", chongdianzhuangPhoto=" + chongdianzhuangPhoto +
			", chongdianzhuangKucunNumber=" + chongdianzhuangKucunNumber +
			", chongdianzhuangNewMoney=" + chongdianzhuangNewMoney +
			", chongdianzhuangContent=" + chongdianzhuangContent +
			", chongdianzhuangDelete=" + chongdianzhuangDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
