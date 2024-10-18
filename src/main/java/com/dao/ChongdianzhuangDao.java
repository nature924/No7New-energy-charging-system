package com.dao;

import com.entity.ChongdianzhuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongdianzhuangView;

/**
 * 充电桩 Dao 接口
 *
 * @author 
 */
public interface ChongdianzhuangDao extends BaseMapper<ChongdianzhuangEntity> {

   List<ChongdianzhuangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
