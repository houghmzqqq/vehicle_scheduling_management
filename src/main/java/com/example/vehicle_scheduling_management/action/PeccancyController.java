package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.PeccancyService;
import com.example.vehicle_scheduling_management.service.ScheduleService;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.PeccancyRecordVO;
import com.example.vehicle_scheduling_management.vo.TruckScheduleShVO;
import com.example.vehicle_scheduling_management.vo.TruckScheduleVO;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by 叶俊锋 on 2018/5/18.
 */
@Controller
@RequestMapping("/peccancy")
public class PeccancyController {

    @Autowired
    private PeccancyService peccancyService;
    @Autowired
    private ScheduleService scheduleService;

    /**
     * @Author: yjf
     * @Description: 跳转到违章记录列表页面
     * @Param: thisPage
     * @Return: String
     * @Date: 22:55 2018/5/18
     */
    @RequestMapping("/toList")
    public String toList(@RequestParam(defaultValue = "1") int thisPage, Model model){
        DividePageVO<PeccancyRecordVO> dividePageVO = peccancyService.divideQuery(thisPage,10);
        model.addAttribute("dividePage",dividePageVO);
        return "/peccancy/peccancy-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<TruckScheduleVO> scheduleVOS = scheduleService.getSchesByStatus("2");
        model.addAttribute("schedules",scheduleVOS);
        return "/peccancy/peccancy-add";
    }

    @RequestMapping("/addPeccancy")
    @ResponseBody
    public String addPeccancy(@RequestParam Integer scheId,PeccancyRecordVO peccancyRecordVO){
        String code = peccancyService.add(peccancyRecordVO,scheId);

        JSONObject jsonObject = new JSONObject();
        if(code.equals("0")){
            jsonObject.accumulate("code","300");
            return jsonObject.toString();
        }

        jsonObject.accumulate("code","200");
        return jsonObject.toString();
    }

    @RequestMapping(value="/getScheInfo",produces="application/json;charset=utf-8")
    @ResponseBody
    public String getScheInfo(@RequestParam Integer id, Model model){
        TruckScheduleShVO scheduleShVO = scheduleService.getScheById(id);

        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("code","200");
        jsonObject.accumulate("rel",scheduleShVO);

        return jsonObject.toString();
    }

    @RequestMapping("/toEdit")
    public String toEdit(PeccancyRecordVO peccancyVO){

        return "";
    }


}
