package com.example.ddd.domain.entities.readonly;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeOnlyKv_HI_RO implements Serializable {
    public static final String QUERY_SQL = " SELECT\n" +
            "\tkv.attribute_name attributeName,\n"+
            "\tkv.attribute_key attributeKey,\n"+
            "\tkv.attribute_type attributeType,\n"+
            "\tkv.bool_v boolV,\n"+
            "\tkv.dbl_v dblV,\n"+
            "\tkv.long_v longV,\n"+
            "\tkv.str_v strV\n"+
            "FROM\n" +
            "\t attribute_kv kv \n" +
            "\tWHERE 1=1  and kv.delete_flag=0  \n";

    public static void main(String[] args) {
        System.out.println(AttributeOnlyKv_HI_RO.QUERY_SQL);
    }
    private String attributeType;
    private String attributeKey;
    private String attributeName;
    private Boolean boolV;
    private String strV;
    private Long longV;
    private Double dblV;
}
