package com.example.vehicle_scheduling_management.config;

import java.util.*;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
public class RoleConfig {

    private static RoleModel model1 = new RoleModel("调度管理", Arrays.asList(
            "","",""));
    private static RoleModel model2 = new RoleModel("司机管理", Arrays.asList(
            "/driver/toList","/driver/toEdit","/driver/updateDriver"
            ,"/driver/delete","/driver/toAdd","/driver/addDriver"));
    private static RoleModel model3 = new RoleModel("车辆管理", Arrays.asList(
            "/truck/toList","/truck/toEdit","/truck/updateTruck"
            ,"/truck/delete","/truck/toAdd","/truck/addTruck"));

    static {
        List<String> roles = new ArrayList<>();
        roles.add("superAdmin");
        roles.add("role1");
        roles.add("role2");

        Map<String, List<RoleModel>> permiss = new HashMap<>();
        permiss.put("superAdmin",Arrays.asList(model1,model2,model3));
        permiss.put("role1",Arrays.asList(model1));
        permiss.put("role2",Arrays.asList(model2,model3));
    }
}

class RoleModel{
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