package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.DriverService;
import com.example.vehicle_scheduling_management.service.OrdersService;
import com.example.vehicle_scheduling_management.service.ScheduleService;
import com.example.vehicle_scheduling_management.service.TruckService;
import com.example.vehicle_scheduling_management.util.MapUtil;
import com.example.vehicle_scheduling_management.vo.*;
import net.sf.json.JSONObject;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: yjf
 * @Description: 车辆调度控制类
 * @Date: create in 10:49 2018/4/23
 * @modified by:
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private TruckService truckService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private DozerBeanMapper beanMapper;

    /**
     * @Author: yjf
     * @Description: 跳转到调度申请页面
     * @Date: 21:00 2018/4/25
     */
    @RequestMapping("/toApply")
    public String toApply1(Model model){
        List<OrdersVO> ordersVOS = ordersService.queryByTypes(0);

        model.addAttribute("orders",ordersVOS);
        return "/schedule/gaode-map";
    }

    /**
     * @Author: yjf
     * @Description: 跳转到新增调度申请页面
     * @Param: orderId
     * @Date: 21:01 2018/4/25
     */
    @RequestMapping("/toAdd")
    public String toAdd(@RequestParam int orderId, Model model){
        OrdersVO ordersVO = ordersService.queryById(orderId);
        List<TruckVO> truckVOS = truckService.queryByStatus(0);
        List<DriverVO> driverVOS = driverService.queryByStatus("4");
        System.out.println(driverVOS);

        model.addAttribute("order",ordersVO);
        model.addAttribute("trucks",truckVOS);
        model.addAttribute("drivers",driverVOS);

        return "/schedule/schedule-add";
    }

    /**
     * @Author: yjf
     * @Description: 获取单个货车信息
     * @Param: id
     * @Return: String(JSON)
     * @Date: 21:01 2018/4/25
     */
    @RequestMapping(value="/getTruckInfo",produces="application/json;charset=utf-8")
    @ResponseBody
    public String getTruckById(@RequestParam int id){
        TruckVO truckVO = truckService.queryById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("code",200);
        JSONObject result = JSONObject.fromObject(truckVO);
        jsonObject.accumulate("result",result);

        return jsonObject.toString();
    }

    /**
     * @Author: yjf
     * @Description: 获取单个司机信息
     * @Param: id
     * @Return: String(JSON)
     * @Date: 21:02 2018/4/25
     */
    @RequestMapping(value="/getDriverInfo",produces="application/json;charset=utf-8")
    @ResponseBody
    public String getDriverById(@RequestParam int id){
        DriverVO driverVO = driverService.queryById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("code",200);
        JSONObject result = JSONObject.fromObject(driverVO);
        jsonObject.accumulate("result",result);

        return jsonObject.toString();
    }

    /**
     * @Author: yjf
     * @Description: 创建调度申请
     * @Param: driverId
     * @Param: truckId
     * @Param: orderId
     * @Date: 21:04 2018/4/25
     */
    @RequestMapping("/create")
    public String createSchedule(@RequestParam int driverId,@RequestParam int truckId,
                                 @RequestParam int orderId){
//        scheduleService.createSchedule(driverId,truckId,orderId);
        scheduleService.createSchedule(driverId,truckId,orderId);
//        System.out.println(orderId + ", " + truckId + ", " + driverId);
        return "redirect:/schedule/toApply";
    }

    /**
     * @Author: yjf
     * @Description: 分页查询车辆调度记录
     * @Param: thisPage
     * @Return: String
     * @Date: 13:57 2018/5/7
     */
    @RequestMapping("/toRecordList")
    public String toRecordList(@RequestParam(defaultValue = "1")int thisPage, Model model){
        DividePageVO<TruckScheduleVO> dividePage = scheduleService.divideQuery(thisPage,10);

        model.addAttribute("dividePage",dividePage);
        return "/schedule/record-list";
    }

    /**
     * @Author: yjf
     * @Description: 提交调度申请
     * @Param: id
     * @Return: String
     * @Date: 13:59 2018/5/7
     */
    @RequestMapping("/submitSche")
    @ResponseBody
    public String submitSche(@RequestParam Integer id){
        scheduleService.submit(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("rel","200");

        return jsonObject.toString();
//        return "redirect:/schedule/toRecordList";
    }


    /**
     * @Author: yjf
     * @Description: 调度申请审核
     * @Param: null
     * @Return: null
     * @Date: 9:50 2018/5/8
     */
    @RequestMapping("/shSche")
    public String shSche(@RequestParam Integer id){
        return "";
    }

    /**
     * @Author: yjf
     * @Description: 调度申请审核列表
     * @Param: thisPage
     * @Return: String
     * @Date: 15:58 2018/5/8
     */
    @RequestMapping("/toShList")
    public String toShList(@RequestParam(defaultValue="1") int thisPage,Model model){
        DividePageVO<TruckScheduleShVO> dividePage = scheduleService.getShList(thisPage,10);

        model.addAttribute("dividePage",dividePage);
        return "/schedule/schedule-sp.html";
    }

    /**
     * @Author: yjf
     * @Description: 获取调度申请的详细信息
     * @Param: null
     * @Return: null
     * @Date: 16:33 2018/5/8
     */
    @RequestMapping("/shCheck")
    @ResponseBody
    public String shCheck(@RequestParam int orderId,@RequestParam int truckId,
                          @RequestParam int driverId){
        OrdersVO ordersVO = ordersService.queryById(orderId);
        TruckVO truckVO = truckService.queryById(truckId);
        DriverVO driverVO = driverService.queryById(driverId);

        JSONObject jsonObject = new JSONObject();
        JSONObject result = new JSONObject();
        result.accumulate("order",ordersVO);
        result.accumulate("truck",truckVO);
        result.accumulate("driver",driverVO);

        jsonObject.accumulate("code",200);
        jsonObject.accumulate("result",result);

//        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }


    @RequestMapping("/toHistory")
    public String toHistory(){
        return "/schedule/historyPath";
    }

    /**
     * @Author: yjf
     * @Description: 获取高德webService中路线规划中的'steps'信息
     * @Param: null
     * @Return: String
     * @Date: 11:50 2018/5/7
     */
    @RequestMapping("/getSteps")
    @ResponseBody
    public String getSteps(){
        return MapUtil.getDirection("惠州市惠城区东江二路1号富力国际大厦");
    }

    @RequestMapping
    @ResponseBody
    public String getHistoryList(){
        return "";
    }
}
