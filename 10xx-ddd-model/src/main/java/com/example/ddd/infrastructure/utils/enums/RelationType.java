package com.example.ddd.infrastructure.utils.enums;

public enum RelationType {
    Contains, //自关联
    CollectorToAsset,  //采集器关联资产
    UpGradeToDevice, //网关升级关联
    DeviceToBroker, //设备关联服务
    DeviceToAlarm,   //设备关联预警规则
    //collectorToMeasure  //采集器关联测点
    DeviceToTopic, //设备关联主题
    DeviceSupplierTypeToPIC,   //设备厂商关联主题
    DeviceToDeviceSupplierType  //设备关联设备厂商型号
}
