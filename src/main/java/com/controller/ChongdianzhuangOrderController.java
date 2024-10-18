
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
 * 充电桩预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chongdianzhuangOrder")
public class ChongdianzhuangOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ChongdianzhuangOrderController.class);

    private static final String TABLE_NAME = "chongdianzhuangOrder";

    @Autowired
    private ChongdianzhuangOrderService chongdianzhuangOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxuiService baoxuiService;//反馈
    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private ChongdianzhuangService chongdianzhuangService;//充电桩
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
        CommonUtil.checkMap(params);
        PageUtils page = chongdianzhuangOrderService.queryPage(params);

        //字典表数据转换
        List<ChongdianzhuangOrderView> list =(List<ChongdianzhuangOrderView>)page.getList();
        for(ChongdianzhuangOrderView c:list){
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
        ChongdianzhuangOrderEntity chongdianzhuangOrder = chongdianzhuangOrderService.selectById(id);
        if(chongdianzhuangOrder !=null){
            //entity转view
            ChongdianzhuangOrderView view = new ChongdianzhuangOrderView();
            BeanUtils.copyProperties( chongdianzhuangOrder , view );//把实体数据重构到view中
            //级联表 充电桩
            //级联表
            ChongdianzhuangEntity chongdianzhuang = chongdianzhuangService.selectById(chongdianzhuangOrder.getChongdianzhuangId());
            if(chongdianzhuang != null){
            BeanUtils.copyProperties( chongdianzhuang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChongdianzhuangId(chongdianzhuang.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chongdianzhuangOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody ChongdianzhuangOrderEntity chongdianzhuangOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chongdianzhuangOrder:{}",this.getClass().getName(),chongdianzhuangOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            chongdianzhuangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        chongdianzhuangOrder.setCreateTime(new Date());
        chongdianzhuangOrder.setInsertTime(new Date());
        chongdianzhuangOrderService.insert(chongdianzhuangOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChongdianzhuangOrderEntity chongdianzhuangOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chongdianzhuangOrder:{}",this.getClass().getName(),chongdianzhuangOrder.toString());
        ChongdianzhuangOrderEntity oldChongdianzhuangOrderEntity = chongdianzhuangOrderService.selectById(chongdianzhuangOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            chongdianzhuangOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            chongdianzhuangOrderService.updateById(chongdianzhuangOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChongdianzhuangOrderEntity> oldChongdianzhuangOrderList =chongdianzhuangOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chongdianzhuangOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChongdianzhuangOrderEntity> chongdianzhuangOrderList = new ArrayList<>();//上传的东西
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
                            ChongdianzhuangOrderEntity chongdianzhuangOrderEntity = new ChongdianzhuangOrderEntity();
//                            chongdianzhuangOrderEntity.setChongdianzhuangId(Integer.valueOf(data.get(0)));   //充电桩 要改的
//                            chongdianzhuangOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            chongdianzhuangOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //充电小时 要改的
//                            chongdianzhuangOrderEntity.setChongdianzhuangOrderTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            chongdianzhuangOrderEntity.setChongdianzhuangOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            chongdianzhuangOrderEntity.setChongdianzhuangOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            chongdianzhuangOrderEntity.setInsertTime(date);//时间
//                            chongdianzhuangOrderEntity.setCreateTime(date);//时间
                            chongdianzhuangOrderList.add(chongdianzhuangOrderEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chongdianzhuangOrderService.insertBatch(chongdianzhuangOrderList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chongdianzhuangOrderService.queryPage(params);

        //字典表数据转换
        List<ChongdianzhuangOrderView> list =(List<ChongdianzhuangOrderView>)page.getList();
        for(ChongdianzhuangOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChongdianzhuangOrderEntity chongdianzhuangOrder = chongdianzhuangOrderService.selectById(id);
            if(chongdianzhuangOrder !=null){


                //entity转view
                ChongdianzhuangOrderView view = new ChongdianzhuangOrderView();
                BeanUtils.copyProperties( chongdianzhuangOrder , view );//把实体数据重构到view中

                //级联表
                    ChongdianzhuangEntity chongdianzhuang = chongdianzhuangService.selectById(chongdianzhuangOrder.getChongdianzhuangId());
                if(chongdianzhuang != null){
                    BeanUtils.copyProperties( chongdianzhuang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChongdianzhuangId(chongdianzhuang.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chongdianzhuangOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody ChongdianzhuangOrderEntity chongdianzhuangOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chongdianzhuangOrder:{}",this.getClass().getName(),chongdianzhuangOrder.toString());
            ChongdianzhuangEntity chongdianzhuangEntity = chongdianzhuangService.selectById(chongdianzhuangOrder.getChongdianzhuangId());
            if(chongdianzhuangEntity == null){
                return R.error(511,"查不到该充电桩");
            }
            // Double chongdianzhuangNewMoney = chongdianzhuangEntity.getChongdianzhuangNewMoney();

            if(false){
            }
            else if(chongdianzhuangEntity.getChongdianzhuangNewMoney() == null){
                return R.error(511,"金额/小时不能为空");
            }
            else if((chongdianzhuangEntity.getChongdianzhuangKucunNumber() -chongdianzhuangOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - chongdianzhuangEntity.getChongdianzhuangNewMoney()*chongdianzhuangOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            chongdianzhuangOrder.setChongdianzhuangOrderTypes(101); //设置订单状态为已预约充电
            chongdianzhuangOrder.setChongdianzhuangOrderTruePrice(chongdianzhuangEntity.getChongdianzhuangNewMoney()*chongdianzhuangOrder.getBuyNumber()); //设置实付价格
            chongdianzhuangOrder.setYonghuId(userId); //设置订单支付人id
            chongdianzhuangOrder.setInsertTime(new Date());
            chongdianzhuangOrder.setCreateTime(new Date());
                chongdianzhuangEntity.setChongdianzhuangKucunNumber( chongdianzhuangEntity.getChongdianzhuangKucunNumber() -chongdianzhuangOrder.getBuyNumber());
                chongdianzhuangService.updateById(chongdianzhuangEntity);
                chongdianzhuangOrderService.insert(chongdianzhuangOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            ChongdianzhuangOrderEntity chongdianzhuangOrder = chongdianzhuangOrderService.selectById(id);//当前表service
            Integer buyNumber = chongdianzhuangOrder.getBuyNumber();
            Integer chongdianzhuangId = chongdianzhuangOrder.getChongdianzhuangId();
            if(chongdianzhuangId == null)
                return R.error(511,"查不到该充电桩");
            ChongdianzhuangEntity chongdianzhuangEntity = chongdianzhuangService.selectById(chongdianzhuangId);
            if(chongdianzhuangEntity == null)
                return R.error(511,"查不到该充电桩");
            Double chongdianzhuangNewMoney = chongdianzhuangEntity.getChongdianzhuangNewMoney();
            if(chongdianzhuangNewMoney == null)
                return R.error(511,"充电桩价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = chongdianzhuangEntity.getChongdianzhuangNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额



            chongdianzhuangEntity.setChongdianzhuangKucunNumber(chongdianzhuangEntity.getChongdianzhuangKucunNumber() + buyNumber);


            chongdianzhuangOrder.setChongdianzhuangOrderTypes(102);//设置订单状态为已取消预约
            chongdianzhuangOrderService.updateById(chongdianzhuangOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            chongdianzhuangService.updateById(chongdianzhuangEntity);//更新订单中充电桩的信息

            return R.ok();
    }

    /**
     * 在充电中
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChongdianzhuangOrderEntity  chongdianzhuangOrderEntity = chongdianzhuangOrderService.selectById(id);
        ChongdianzhuangEntity chongdianzhuangEntity=chongdianzhuangService.selectById(chongdianzhuangOrderEntity.getChongdianzhuangId());
        chongdianzhuangEntity.setChongdianzhuangZhuangtaiTypes(1);
        chongdianzhuangOrderEntity.setChongdianzhuangOrderTypes(103);//设置订单状态为已在充电中
        chongdianzhuangOrderService.updateById( chongdianzhuangOrderEntity);
        chongdianzhuangService.updateById(chongdianzhuangEntity);
        return R.ok();
    }


    /**
     * 完成充电
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ChongdianzhuangOrderEntity  chongdianzhuangOrderEntity = chongdianzhuangOrderService.selectById(id);
        ChongdianzhuangEntity chongdianzhuangEntity=chongdianzhuangService.selectById(chongdianzhuangOrderEntity.getChongdianzhuangId());
        chongdianzhuangEntity.setChongdianzhuangZhuangtaiTypes(2);
        chongdianzhuangOrderEntity.setChongdianzhuangOrderTypes(104);//设置订单状态为完成充电
        chongdianzhuangOrderService.updateById( chongdianzhuangOrderEntity);
        chongdianzhuangService.updateById(chongdianzhuangEntity);
        return R.ok();
    }

}

