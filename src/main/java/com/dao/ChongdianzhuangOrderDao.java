package com.dao;

import com.entity.ChongdianzhuangOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongdianzhuangOrderView;

/**
 * 充电桩预约 Dao 接口
 *
 * @author 
 */
public interface ChongdianzhuangOrderDao extends BaseMapper<ChongdianzhuangOrderEntity> {

   List<ChongdianzhuangOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
