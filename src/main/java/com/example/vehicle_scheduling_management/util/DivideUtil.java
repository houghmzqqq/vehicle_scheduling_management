package com.example.vehicle_scheduling_management.util;

import com.example.vehicle_scheduling_management.pojo.TruckPO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yjf
 * @Description: 分页查询工具，生成一些分页信息
 * @Date: create in 21:04 2018/4/16
 * @modified by:
 */
@Component
public class DivideUtil {

    private DividePageVO dividePage;

    public DivideUtil() {
        this.dividePage = new DividePageVO();
    }

    /**
     * @Author: yjf
     * @Description: 获取分页信息
     * @Param: thisPage
     * @Param: rowOfEachPage
     * @Param: pageCount
     * @Return: DividePageVO
     * @Date: 21:37 2018/4/16
     */
    public DividePageVO getDividePageVO(int thisPage, int rowOfEachPage, int pageCount) {

        int maxPage;
        int nextPage;
        int prePage;
        int start;
        int end;
        List<Integer> startAndEnd = new ArrayList<>();

        if((pageCount%rowOfEachPage) != 0)
        {
            maxPage = (pageCount/rowOfEachPage)+1;
        }
        else
        {
            maxPage = (pageCount/rowOfEachPage);
        }
        if(thisPage >= maxPage)
        {
            nextPage = thisPage;
        }
        else
        {
            nextPage = thisPage+1;
        }
        if (thisPage > 1){
            prePage = thisPage-1;
        }else{
            prePage = thisPage;
        }

        if(maxPage < 5){
            start = 1;
            end = maxPage;
        }else{
            if(thisPage <= 3){
                start = 1;
                end = 5;
            }else if(thisPage >= maxPage-2){
                start = maxPage-4;
                end = maxPage;
            }else{
                start = thisPage-2;
                end = thisPage+2;
            }
        }

        for(int i=start;i<=end;i++){
            startAndEnd.add(i);
        }

        dividePage.setThisPage(thisPage);
        dividePage.setRowOfEachPage(rowOfEachPage);
        dividePage.setLastPage(maxPage);
        dividePage.setNextPage(nextPage);
        dividePage.setPageCount(pageCount);
        dividePage.setPrePage(prePage);
        dividePage.setStartAndEnd(startAndEnd);

        return dividePage;
    }
}
