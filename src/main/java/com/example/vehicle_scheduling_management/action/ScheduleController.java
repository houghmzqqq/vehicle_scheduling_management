package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.OrdersService;
import com.example.vehicle_scheduling_management.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/toApply")
    public String toApply1(Model model){
        List<OrdersVO> ordersVOS = ordersService.queryByTypes(0);

        model.addAttribute("orders",ordersVOS);
        return "/schedule/gaode-map";
    }


}
