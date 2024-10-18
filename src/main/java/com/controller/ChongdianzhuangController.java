
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 充电桩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chongdianzhuang")
public class ChongdianzhuangController {
    private static final Logger logger = LoggerFactory.getLogger(ChongdianzhuangController.class);

    private static final String TABLE_NAME = "chongdianzhuang";

    @Autowired
    private ChongdianzhuangService chongdianzhuangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxuiService baoxuiService;//反馈
    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private ChongdianzhuangOrderService chongdianzhuangOrderService;//充电桩预约
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//新能源公告
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("chongdianzhuangDeleteStart",1);params.put("chongdianzhuangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chongdianzhuangService.queryPage(params);

        //字典表数据转换
        List<ChongdianzhuangView> list =(List<ChongdianzhuangView>)page.getList();
        for(ChongdianzhuangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongdianzhuangEntity chongdianzhuang = chongdianzhuangService.selectById(id);
        if(chongdianzhuang !=null){
            //entity转view
            ChongdianzhuangView view = new ChongdianzhuangView();
            BeanUtils.copyProperties( chongdianzhuang , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChongdianzhuangEntity chongdianzhuang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chongdianzhuang:{}",this.getClass().getName(),chongdianzhuang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChongdianzhuangEntity> queryWrapper = new EntityWrapper<ChongdianzhuangEntity>()
            .eq("chongdianzhuang_name", chongdianzhuang.getChongdianzhuangName())
            .eq("chongdianzhuang_types", chongdianzhuang.getChongdianzhuangTypes())
            .eq("chongdianzhuang_zhuangtai_types", chongdianzhuang.getChongdianzhuangZhuangtaiTypes())
            .eq("chongdianzhuang_kucun_number", chongdianzhuang.getChongdianzhuangKucunNumber())
            .eq("shangxia_types", chongdianzhuang.getShangxiaTypes())
            .eq("chongdianzhuang_delete", chongdianzhuang.getChongdianzhuangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongdianzhuangEntity chongdianzhuangEntity = chongdianzhuangService.selectOne(queryWrapper);
        if(chongdianzhuangEntity==null){
            chongdianzhuang.setShangxiaTypes(1);
            chongdianzhuang.setChongdianzhuangDelete(1);
            chongdianzhuang.setInsertTime(new Date());
            chongdianzhuang.setCreateTime(new Date());
            chongdianzhuangService.insert(chongdianzhuang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChongdianzhuangEntity chongdianzhuang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chongdianzhuang:{}",this.getClass().getName(),chongdianzhuang.toString());
        ChongdianzhuangEntity oldChongdianzhuangEntity = chongdianzhuangService.selectById(chongdianzhuang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chongdianzhuang.getChongdianzhuangPhoto()) || "null".equals(chongdianzhuang.getChongdianzhuangPhoto())){
                chongdianzhuang.setChongdianzhuangPhoto(null);
        }

            chongdianzhuangService.updateById(chongdianzhuang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChongdianzhuangEntity> oldChongdianzhuangList =chongdianzhuangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChongdianzhuangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChongdianzhuangEntity chongdianzhuangEntity = new ChongdianzhuangEntity();
            chongdianzhuangEntity.setId(id);
            chongdianzhuangEntity.setChongdianzhuangDelete(2);
            list.add(chongdianzhuangEntity);
        }
        if(list != null && list.size() >0){
            chongdianzhuangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ChongdianzhuangEntity> chongdianzhuangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChongdianzhuangEntity chongdianzhuangEntity = new ChongdianzhuangEntity();
//                            chongdianzhuangEntity.setChongdianzhuangName(data.get(0));                    //充电桩名称 要改的
//                            chongdianzhuangEntity.setChongdianzhuangUuidNumber(data.get(0));                    //充电桩编号 要改的
//                            chongdianzhuangEntity.setChongdianzhuangPhoto("");//详情和图片
//                            chongdianzhuangEntity.setChongdianzhuangTypes(Integer.valueOf(data.get(0)));   //充电桩类型 要改的
//                            chongdianzhuangEntity.setChongdianzhuangZhuangtaiTypes(Integer.valueOf(data.get(0)));   //充电桩状态 要改的
//                            chongdianzhuangEntity.setChongdianzhuangKucunNumber(Integer.valueOf(data.get(0)));   //可充时长 要改的
//                            chongdianzhuangEntity.setChongdianzhuangNewMoney(data.get(0));                    //金额/小时 要改的
//                            chongdianzhuangEntity.setChongdianzhuangContent("");//详情和图片
//                            chongdianzhuangEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chongdianzhuangEntity.setChongdianzhuangDelete(1);//逻辑删除字段
//                            chongdianzhuangEntity.setInsertTime(date);//时间
//                            chongdianzhuangEntity.setCreateTime(date);//时间
                            chongdianzhuangList.add(chongdianzhuangEntity);


                            //把要查询是否重复的字段放入map中
                                //充电桩编号
                                if(seachFields.containsKey("chongdianzhuangUuidNumber")){
                                    List<String> chongdianzhuangUuidNumber = seachFields.get("chongdianzhuangUuidNumber");
                                    chongdianzhuangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chongdianzhuangUuidNumber = new ArrayList<>();
                                    chongdianzhuangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chongdianzhuangUuidNumber",chongdianzhuangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //充电桩编号
                        List<ChongdianzhuangEntity> chongdianzhuangEntities_chongdianzhuangUuidNumber = chongdianzhuangService.selectList(new EntityWrapper<ChongdianzhuangEntity>().in("chongdianzhuang_uuid_number", seachFields.get("chongdianzhuangUuidNumber")).eq("chongdianzhuang_delete", 1));
                        if(chongdianzhuangEntities_chongdianzhuangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChongdianzhuangEntity s:chongdianzhuangEntities_chongdianzhuangUuidNumber){
                                repeatFields.add(s.getChongdianzhuangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [充电桩编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chongdianzhuangService.insertBatch(chongdianzhuangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ChongdianzhuangView> returnChongdianzhuangViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = chongdianzhuangOrderService.queryPage(params1);
        List<ChongdianzhuangOrderView> orderViewsList =(List<ChongdianzhuangOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ChongdianzhuangOrderView orderView:orderViewsList){
            Integer chongdianzhuangTypes = orderView.getChongdianzhuangTypes();
            if(typeMap.containsKey(chongdianzhuangTypes)){
                typeMap.put(chongdianzhuangTypes,typeMap.get(chongdianzhuangTypes)+1);
            }else{
                typeMap.put(chongdianzhuangTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("chongdianzhuangTypes",type);
            PageUtils pageUtils1 = chongdianzhuangService.queryPage(params2);
            List<ChongdianzhuangView> chongdianzhuangViewList =(List<ChongdianzhuangView>)pageUtils1.getList();
            returnChongdianzhuangViewList.addAll(chongdianzhuangViewList);
            if(returnChongdianzhuangViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = chongdianzhuangService.queryPage(params);
        if(returnChongdianzhuangViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnChongdianzhuangViewList.size();//要添加的数量
            List<ChongdianzhuangView> chongdianzhuangViewList =(List<ChongdianzhuangView>)page.getList();
            for(ChongdianzhuangView chongdianzhuangView:chongdianzhuangViewList){
                Boolean addFlag = true;
                for(ChongdianzhuangView returnChongdianzhuangView:returnChongdianzhuangViewList){
                    if(returnChongdianzhuangView.getId().intValue() ==chongdianzhuangView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnChongdianzhuangViewList.add(chongdianzhuangView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnChongdianzhuangViewList = returnChongdianzhuangViewList.subList(0, limit);
        }

        for(ChongdianzhuangView c:returnChongdianzhuangViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnChongdianzhuangViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chongdianzhuangService.queryPage(params);

        //字典表数据转换
        List<ChongdianzhuangView> list =(List<ChongdianzhuangView>)page.getList();
        for(ChongdianzhuangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongdianzhuangEntity chongdianzhuang = chongdianzhuangService.selectById(id);
            if(chongdianzhuang !=null){


                //entity转view
                ChongdianzhuangView view = new ChongdianzhuangView();
                BeanUtils.copyProperties( chongdianzhuang , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChongdianzhuangEntity chongdianzhuang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chongdianzhuang:{}",this.getClass().getName(),chongdianzhuang.toString());
        Wrapper<ChongdianzhuangEntity> queryWrapper = new EntityWrapper<ChongdianzhuangEntity>()
            .eq("chongdianzhuang_name", chongdianzhuang.getChongdianzhuangName())
            .eq("chongdianzhuang_uuid_number", chongdianzhuang.getChongdianzhuangUuidNumber())
            .eq("chongdianzhuang_types", chongdianzhuang.getChongdianzhuangTypes())
            .eq("chongdianzhuang_zhuangtai_types", chongdianzhuang.getChongdianzhuangZhuangtaiTypes())
            .eq("chongdianzhuang_kucun_number", chongdianzhuang.getChongdianzhuangKucunNumber())
            .eq("shangxia_types", chongdianzhuang.getShangxiaTypes())
            .eq("chongdianzhuang_delete", chongdianzhuang.getChongdianzhuangDelete())
//            .notIn("chongdianzhuang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChongdianzhuangEntity chongdianzhuangEntity = chongdianzhuangService.selectOne(queryWrapper);
        if(chongdianzhuangEntity==null){
            chongdianzhuang.setChongdianzhuangDelete(1);
            chongdianzhuang.setInsertTime(new Date());
            chongdianzhuang.setCreateTime(new Date());
        chongdianzhuangService.insert(chongdianzhuang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

