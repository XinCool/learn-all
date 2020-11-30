package com.example.ddd.infrastructure.utils.enums;

public enum AttributeKeyType {
    DEP_ID,  //通过key的条件查询所属部门
    DEP_NAME, //部门名称
    user_id,  //通过key的条件查询部门管理员  PSN_ID 转为 user_id
    user_name, //用户名字
    TAG_IDS,  //绑定标签集合
    ac_code, //资产编码
    ac_id,   //资产ID
    mapPoint,   //地图位置
    contact_email, //邮箱
    contact_phone,  //手机号
    area_name   //区域位置

}
