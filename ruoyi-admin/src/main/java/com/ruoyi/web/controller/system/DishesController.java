package com.ruoyi.web.controller.system;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.utils.SnowFlake;
import com.ruoyi.web.domain.Dishes;
import com.ruoyi.web.domain.DishesType;
import com.ruoyi.web.domain.Order;
import com.ruoyi.web.service.IDishesTypeService;
import com.ruoyi.web.service.IOrderService;
import com.ruoyi.web.service.impl.DishesTypeServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.service.IDishesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 菜品Controller
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Controller
@RequestMapping("/dishes")
public class DishesController extends BaseController
{
    private final String prefix = "system/dishes";

    @Autowired
    private IDishesService dishesService;

    @Autowired
    private IDishesTypeService dishesTypeService;

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping()
    public String dishes()
    {
        return prefix + "/dishes";
    }

    /**
     * 查询菜品列表分页
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dishes dishes)
    {
        startPage();
        List<Dishes> list = dishesService.selectDishesList(dishes);

        return getDataTable(list);
    }

    /**
     * 查询菜品不分页
     * @param dishes
     * @return
     */
    @PostMapping("/list/noPage")
    @ResponseBody
    public TableDataInfo listNoPage(Dishes dishes)
    {
        List<Dishes> list = dishesService.selectDishesList(dishes);

        return getDataTable(list);
    }

    /**
     * 导出菜品列表
     */
    @Log(title = "菜品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Dishes dishes)
    {
        List<Dishes> list = dishesService.selectDishesList(dishes);
        ExcelUtil<Dishes> util = new ExcelUtil<Dishes>(Dishes.class);
        return util.exportExcel(list, "dishes");
    }

    /**
     * 新增菜品
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        map.put("dishesTypeAll", dishesTypeService.selectDishesTypeList(new DishesType()));
        return prefix + "/add";
    }

    /**
     * 新增保存菜品
     */
    @Log(title = "菜品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dishes dishes)
    {
        return toAjax(dishesService.insertDishes(dishes));
    }

    /**
     * 上传图片文件
     */
    @Log(title = "信息", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult saveImage(@RequestParam("file") MultipartFile file, Dishes dishes) throws IOException {
        if (file != null) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
//            String filePath2 = RuoYiConfig.getUploadPathRoot();
            // 上传
            String fileName = FileUploadUtils.upload(filePath, file);
            dishes.setImagePath(fileName);
        }
        return toAjax(dishesService.insertDishes(dishes));
    }

    /**
     * 修改菜品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Dishes dishes = dishesService.selectDishesById(id);
        mmap.put("dishes", dishes);
        mmap.put("dishesTypeAll", dishesTypeService.selectDishesTypeList(new DishesType()));
        return prefix + "/edit";
    }

    /**
     * 修改菜品图片页面
     */
    @GetMapping("/avatar/{id}")
    public String avatar(@PathVariable("id") Long id, ModelMap mmap)
    {
        Dishes dishes = dishesService.selectDishesById(id);
        mmap.put("dishes", dishes);
        mmap.put("dishesTypeAll", dishesTypeService.selectDishesTypeList(new DishesType()));
        return prefix + "/avatar";
    }

    /**
     * 修改保存菜品
     */
    @Log(title = "菜品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dishes dishes)
    {
        return toAjax(dishesService.updateDishes(dishes));
    }

    /**
     * 修改保存菜品
     */
    @Log(title = "菜品", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImage")
    @ResponseBody
    public AjaxResult uploadImage(@RequestParam("imageFile") MultipartFile file, Dishes dishes)
    {
        if(file != null) {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传
            String fileName;
            try {
                fileName = FileUploadUtils.upload(filePath, file);
            } catch (IOException e) {
                e.printStackTrace();
                return AjaxResult.error("修改图片异常");
            }
            dishes.setImagePath(fileName);
        }
        return toAjax(dishesService.updateDishes(dishes));
    }

    /**
     * 删除菜品
     */
    @Log(title = "菜品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dishesService.deleteDishesByIds(ids));
    }

//    @ResponseBody
//    @GetMapping("/test")
    public void test(String message) {
        ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
        try {
            // 音量 0-100
            sap.setProperty("Volume", new Variant(100));
            // 语音朗读速度 -10 到 +10
            sap.setProperty("Rate", new Variant(-2));
            // 获取执行对象
            Dispatch sapo = sap.getObject();
            // 执行朗读
            Dispatch.call(sapo, "Speak", new Variant(message));
            // 关闭执行对象
            sapo.safeRelease();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭应用程序连接
            sap.safeRelease();
        }
    }

    /**
     * 模拟订单生成
     */
    @ResponseBody
    @GetMapping("/test")
    public void orderInsert() {
        // 订单生成
        Order order = new Order();
        order.setId(SnowFlake.nextId());
        order.setPeopleNum(4L);
        order.setTableNumber("A01");
        order.setTotalAmount(new BigDecimal(168));
        order.setState(1);
        // 模拟新增订单
        iOrderService.insertOrder(order);
        // 发送消息队列
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "您好，您有一份新的订单，请及时处理！";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.order", manMap);
    }

}
