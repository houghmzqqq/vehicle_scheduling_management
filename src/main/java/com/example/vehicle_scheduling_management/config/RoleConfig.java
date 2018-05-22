package com.example.vehicle_scheduling_management.config;

import java.util.*;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
public class RoleConfig {

    //权限，存储角色能够访问的模块
    private static Map<String,List<RoleModel>> permiss;

    //每个模块能够访问的uri
    private RoleModel model1 = new RoleModel("调度管理", Arrays.asList(
            "/schedule/toApply","/schedule/toAdd","/schedule/getTruckInfo",
            "/schedule/getDriverInfo","/schedule/create","/schedule/toHistory",
            "/schedule/toRecordList","/schedule/submitSche","/schedule/toShList",
            "/schedule/shSche","/schedule/shCheck","/schedule/getSteps",
            "/schedule/getLsgjList","/schedule/toApply2","/schedule/getPois",
            "/schedule/getOrdersPath"));
    private RoleModel model2 = new RoleModel("司机管理", Arrays.asList(
            "/driver/toList","/driver/toEdit","/driver/updateDriver"
            ,"/driver/delete","/driver/toAdd","/driver/addDriver"));
    private RoleModel model3 = new RoleModel("车辆管理", Arrays.asList(
            "/truck/toList","/truck/toEdit","/truck/updateTruck"
            ,"/truck/delete","/truck/toAdd","/truck/addTruck"));
    private RoleModel model4 = new RoleModel("违章管理",Arrays.asList(
            "/peccancy/toList","/peccancy/toAdd","/peccancy/toEdit"));

    //实例化时，加载各个角色的权限
    public RoleConfig(){
        permiss = new HashMap<>();
        permiss.put("superAdmin",Arrays.asList(model1,model2,model3,model4));
        permiss.put("role1",Arrays.asList(model1));
        permiss.put("role2",Arrays.asList(model2,model3,model4));
    }

    public Map<String, List<RoleModel>> getPermiss() {
        return permiss;
    }

    //内部内，存放系统模块对应的uri
    public class RoleModel{
        private String modelName;
        private List<String> urls;

        public RoleModel(String modelName, List<String> url) {
            this.modelName = modelName;
            this.urls = url;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }
}