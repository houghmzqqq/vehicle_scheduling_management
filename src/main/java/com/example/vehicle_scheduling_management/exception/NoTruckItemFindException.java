package com.example.vehicle_scheduling_management.exception;

/**
 * Created by 叶俊锋 on 2018/5/16.
 */
public class NoTruckItemFindException extends Exception {
    public NoTruckItemFindException() {
    }

    public NoTruckItemFindException(String message) {
        super(message);
    }
}
