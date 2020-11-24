package com.example.excel.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author Cool
 * @create 2020-09-21 10:23
 */

@Data
public class UserDto {
    @ApiModelProperty(value = "编号")
    private String id;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "用户年龄")
    private Integer age;
}
