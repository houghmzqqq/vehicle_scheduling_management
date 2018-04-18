package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.TruckService;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.TruckVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: yjf
 * @Description:
 * @Date: create in 20:22 2018/4/16
 * @modified by:
 */
@Controller
@RequestMapping("/truck")
public class TruckController {

    @Autowired
    private TruckService truckService;

    /**
     * @Author: yjf
     * @Description: 分页显示车辆列表
     * @Param: thisPage
     * @Date: 21:39 2018/4/16
     */
    @RequestMapping("/toList")
    public String toTruckList(@RequestParam(defaultValue = "1") Integer thisPage, Model model){
        DividePageVO<TruckVO> dividePageVO = truckService.divideQuery(thisPage,5);
        model.addAttribute("dividePage",dividePageVO);
        return "/truck/truck-list";
    }

    /**
     * @Author: yjf
     * @Description: 显示车辆信息录入界面
     * @Date: 21:41 2018/4/16
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/truck/truck-add";
    }

    /**
     * @Author: yjf
     * @Description: 向数据库新增一条车辆记录
     * @Param: truckVO
     * @Date: 21:45 2018/4/16
     */
    @RequestMapping("/addTruck")
    public String addTruck(TruckVO truckVO){
        truckService.add(truckVO);
        return "redirect:/truck/toList";
    }

    /**
     * @Author: yjf
     * @Description: 跳转到车辆信息编辑页面
     * @Param: id
     * @Date: 21:45 2018/4/16
     */
    @RequestMapping("/toEdit")
    public String toEdit(@RequestParam Integer id, Model model){
        TruckVO truckVO = truckService.queryById(id);
        model.addAttribute("truck",truckVO);
        return "/truck/truck-edit";
    }

    /**
     * @Author: yjf
     * @Description: 更新车辆信息
     * @Param: truckVO
     * @Date: 21:48 2018/4/16
     */
    @RequestMapping("/updateTruck")
    @ResponseBody
    public String updateTruck(TruckVO truckVO){
        truckService.update(truckVO);
//        return "redirect:/truck/toList";
        return "{\"rel\": \"yes\"}";
    }

    /**
     * @Author: yjf
     * @Description: 删除车辆信息
     * @Param: id
     * @Date: 21:48 2018/4/16
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam Integer id){
        truckService.delete(id);
        return "redirect:/truck/toList";
    }
}
