package com.dao;

import com.entity.BaoxuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BaoxuiView;

/**
 * 反馈 Dao 接口
 *
 * @author 
 */
public interface BaoxuiDao extends BaseMapper<BaoxuiEntity> {

   List<BaoxuiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
