package com.example.vehicle_scheduling_management.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yjf
 * @Description: 分页查询工具类
 * @Date: create in 11:32 2018/4/15
 * @modified by:
 */
@Component
public class DividePageVO<T> implements Serializable {
    private int rowOfEachPage = 5;//每一页行数
    private int pageCount;
    private int thisPage = 1;//当前页号
    private int prePage;
    private int nextPage;
    private int lastPage;//最后一页
    private List<Integer> startAndEnd;

    private List<T> ObjList; //列表页面存储的对象

    public DividePageVO() {
    }

    public int getRowOfEachPage() {
        return rowOfEachPage;
    }

    public void setRowOfEachPage(int rowOfEachPage) {
        this.rowOfEachPage = rowOfEachPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(int thisPage) {
        this.thisPage = thisPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<Integer> getStartAndEnd() {
        return startAndEnd;
    }

    public void setStartAndEnd(List<Integer> startAndEnd) {
        this.startAndEnd = startAndEnd;
    }

    public List<T> getObjList() {
        return ObjList;
    }

    public void setObjList(List<T> objList) {
        ObjList = objList;
    }

    @Override
    public String toString() {
        return "DividePageVO{" +
                "rowOfEachPage=" + rowOfEachPage +
                ", pageCount=" + pageCount +
                ", thisPage=" + thisPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", lastPage=" + lastPage +
                ", startAnEnd=" + startAndEnd +
                ", ObjList=" + ObjList +
                '}';
    }
}
