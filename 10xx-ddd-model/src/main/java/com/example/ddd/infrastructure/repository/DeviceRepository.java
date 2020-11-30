package com.example.ddd.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.device.aggregates.Device;
import com.example.ddd.domain.device.entities.AttributeKvInfo;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.domain.device.vo.RelationInfo;
import com.example.ddd.domain.device.repository.IDeviceRepository;
import com.example.ddd.infrastructure.dao.readonly.AttributeOnlyKvDAO_HI_RO;
import com.example.ddd.infrastructure.dao.readonly.DeviceWithKvAndParentIdDAO_HI_RO;
import com.example.ddd.infrastructure.entities.AttributeKvEntity_HI;
import com.example.ddd.infrastructure.entities.DeviceEntity_HI;
import com.example.ddd.infrastructure.entities.RelationEntity_HI;
import com.example.ddd.infrastructure.entities.readonly.AttributeOnlyKv_HI_RO;
import com.example.ddd.infrastructure.entities.readonly.DeviceWithKvAndParentId_HI_RO;
import com.example.ddd.infrastructure.utils.enums.EntityType;
import com.example.ddd.infrastructure.utils.enums.RelationType;
import com.example.ddd.infrastructure.utils.enums.RelationTypeGroup;
import com.sie.iot.common.bean.OrderByBean;
import com.sie.iot.common.util.SaafToolUtils;
import com.siefw.base.utils.SToolUtils;
import com.siefw.base.utils.StringUtils;
import com.siefw.hibernate.core.dao.ViewObject;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cool
 * @create 2020-11-16
 */
@Component("deviceRepository")
public class DeviceRepository implements IDeviceRepository {

    @Autowired
    private ViewObject<DeviceEntity_HI> deviceDAO_HI;
    @Autowired
    private ViewObject<RelationEntity_HI> relationDAO_HI;
    @Autowired
    private ViewObject<AttributeKvEntity_HI> attributeKvDAO_HI;
    @Autowired
    private DeviceWithKvAndParentIdDAO_HI_RO deviceParentDAO_HI_RO;
    @Autowired
    private AttributeOnlyKvDAO_HI_RO attributeOnlyKvDAO_HI_RO;


    @Override
    public Pagination<DeviceInfo> getDevicePagination(JSONObject queryParamJSON, Integer pageIndex, Integer pageRows, OrderByBean orderBean) {
        Map<String, Object> paramsMap;
        if (queryParamJSON != null) {
            paramsMap = SToolUtils.fastJsonObj2Map(queryParamJSON);
        } else {
            paramsMap = new HashMap<>();
        }
        StringBuffer querySQLSB = new StringBuffer(" from DeviceEntity_HI where 1=1 ");
        if (orderBean != null) {
            SaafToolUtils.sortUtil(orderBean, querySQLSB);
        }
        Pagination<DeviceEntity_HI> entityPagination = deviceDAO_HI.findPagination(querySQLSB.toString(), paramsMap, pageIndex, pageRows);
        Pagination<DeviceInfo> devicePagination = new Pagination<>();
        BeanUtil.copyProperties(entityPagination, devicePagination);
        return devicePagination;
    }

    /**
     * 根据设备Id设备信息
     *
     * @param id
     * @return
     */
    @Override
    public DeviceInfo getById(String id) {
        DeviceEntity_HI deviceEntityHI = deviceDAO_HI.getById(id);
        DeviceInfo device = new DeviceInfo();
        BeanUtil.copyProperties(deviceEntityHI, device);
        return device;
    }

    @Override
    public Pagination<Device> findDeviceKvParent(JSONObject jsonObject, Integer pageIndex, Integer pageRows, OrderByBean orderByBean) {
        StringBuffer sql = new StringBuffer(DeviceWithKvAndParentId_HI_RO.QUERY_SQL);
        Map<String, Object> params = new HashMap<>();
        StringBuffer kvSql = new StringBuffer(AttributeOnlyKv_HI_RO.QUERY_SQL + " AND entity_type='DEVICE'");
        //tenant_id
        if (StrUtil.isNotBlank(jsonObject.getString("childTenantIds"))) {
            String tenantIds = jsonObject.getString("childTenantIds") + ",'" + jsonObject.getString("tenantId") + "'";
            //超级管理员和管理员有下级租户  获取下级租户和自己的所有设备
            sql.append(" and d.tenant_id in  (" + tenantIds + ") ");
        } else if (StrUtil.isNotBlank(jsonObject.getString("tenantId"))) {
            //没有下级租户 并且传入租户Id
            sql.append(" and d.tenant_id = :tenantId ");
            params.put("tenantId", jsonObject.getString("tenantId"));
        }

        boolean ifParamsAllNull = true;
        //fromId
        if (StrUtil.isNotBlank(jsonObject.getString("fromId"))) {
            if (ifParamsAllNull) {
                ifParamsAllNull = false;
            }
            sql.append(" AND d.id in (select r.to_id from relation r where r.from_type = '" + EntityType.DEVICE.name() + "'  and r.delete_flag=0 and  r.to_type = '" + EntityType.DEVICE.name()
                    + "'  and r.from_id = '" + jsonObject.getString("fromId") + "' and r.relation_type_group = '" + RelationTypeGroup.COMMON.name()
                    + "' and r.relation_type = '" + RelationType.Contains.name() + "') ");
        }
        //assetId
        if (StrUtil.isNotBlank(jsonObject.getString("assetId"))) {
            if (ifParamsAllNull) {
                ifParamsAllNull = false;
            }
            sql.append(" AND d.id in (select r.from_id from relation r where r.from_type = '" + EntityType.DEVICE.name() + "'  and r.delete_flag=0 and  r.to_type = '" + EntityType.ASSET.name()
                    + "'  and r.to_id = '" + jsonObject.getString("assetId") + "' and r.relation_type_group = '" + RelationTypeGroup.COMMON.name()
                    + "' and r.relation_type = '" + RelationType.CollectorToAsset.name() + "') ");
        }
        //name
        if (StringUtils.isNotEmpty(jsonObject.getString("name"))) {
            if (ifParamsAllNull) {
                ifParamsAllNull = false;
            }
            sql.append(" and d.name like '%" + jsonObject.getString("name") + "%'");
        }
        //type
        if (StringUtils.isNotEmpty(jsonObject.getString("type"))) {
            if (ifParamsAllNull) {
                ifParamsAllNull = false;
            }
            sql.append(" and d.type = :type");
            params.put("type", jsonObject.getString("type"));
        }

        //attributeKey
        if (StrUtil.isNotBlank(jsonObject.getString("attributeKey"))) {
            if (ifParamsAllNull) {
                ifParamsAllNull = false;
            }
            sql.append(" AND kv.attribute_key = '" + jsonObject.getString("attributeKey") + "'");
            kvSql.append(" AND attribute_key = '" + jsonObject.getString("attributeKey") + "'");
        }
        //attributeValue
        if (StrUtil.isNotBlank(jsonObject.getString("attributeValue"))) {
            if (ifParamsAllNull) {
                ifParamsAllNull = false;
            }
            Object value = jsonObject.get("attributeValue");
            //LOGGER.info("value:" + value.getClass());
            if (value instanceof Boolean) {
                sql.append(" AND kv.bool_v = :attributeBoolValue");
                params.put("attributeBoolValue", value);
                kvSql.append(" AND bool_v = " + value);
            } else if (value instanceof Double || value instanceof BigDecimal) {
                sql.append(" AND kv.dbl_v = :attributeDblValue");
                params.put("attributeDblValue", value);
                kvSql.append(" AND dbl_v = " + value);
            } else if (value instanceof Long || value instanceof Integer) {
                sql.append(" AND kv.long_v = :attributeLongValue");
                params.put("attributeLongValue", value);
                kvSql.append(" AND long_v = " + value);
            } else {
                sql.append(" AND kv.str_v = '" + value + "'");
                kvSql.append(" AND str_v = '" + value + "'");
            }
        }

        //参数为空，默认查询顶级设备
        if (ifParamsAllNull) {
            sql.append(" AND d.id not in (select to_id from relation where from_type='" + EntityType.DEVICE.name() + "' and  delete_flag=0   AND to_type = '" + EntityType.DEVICE.name()
                    + "' AND relation_type_group='" + RelationTypeGroup.COMMON.name() + "' AND relation_type='" + RelationType.Contains.name() + "')");
        }
        sql.append(" group by d.id ");
        //orderbean
        if (orderByBean == null) {
            OrderByBean orderByBeanDefault = new OrderByBean();
            orderByBeanDefault.setAttributeName("d.creation_date");
            orderByBeanDefault.setSortType("desc");
            orderByBean = orderByBeanDefault;
        }

        SaafToolUtils.sortUtil(orderByBean, sql);
        Pagination<DeviceWithKvAndParentId_HI_RO> deviceWithKvAndParentId_HI_ROs = deviceParentDAO_HI_RO.findPagination(sql, params, pageIndex, pageRows);

        List<DeviceWithKvAndParentId_HI_RO> deviceWithKvAndParentId_HI_RO = deviceWithKvAndParentId_HI_ROs.getData();

        //LOGGER.info("size:" + deviceWithKvAndParentId_HI_RO.size());
        if (deviceWithKvAndParentId_HI_RO.size() != 0) {
            for (int i = 0; i < deviceWithKvAndParentId_HI_RO.size(); i++) {
                DeviceWithKvAndParentId_HI_RO deviceRo = deviceWithKvAndParentId_HI_RO.get(i);
                List<AttributeOnlyKv_HI_RO> attributes = attributeOnlyKvDAO_HI_RO.findList(kvSql + " AND kv.entity_id='" + deviceRo.getId() + "'");
                deviceRo.setAttributes(attributes);
            }
        }
        Pagination<Device> pagination = new Pagination<>();
        List<DeviceWithKvAndParentId_HI_RO> data = deviceWithKvAndParentId_HI_ROs.getData();
        //复制
        BeanUtil.copyProperties(deviceWithKvAndParentId_HI_ROs,pagination,"data");
        //data
        List<Device> deviceData = new ArrayList<>();
        for (DeviceWithKvAndParentId_HI_RO deviceRo : data) {
            //AttributeKvs Device
            List<AttributeOnlyKv_HI_RO> attributes = deviceRo.getAttributes();
            List<AttributeKvInfo> attributeKvInfos = new ArrayList<>();
            attributes.forEach(attributeOnlyKv_hi_ro -> {
                AttributeKvInfo attributeKvInfo = new AttributeKvInfo();
                BeanUtil.copyProperties(attributeOnlyKv_hi_ro,attributeKvInfo);
                attributeKvInfos.add(attributeKvInfo);
            });

            //DeviceInfo device
            DeviceInfo deviceInfo = new DeviceInfo();
            BeanUtil.copyProperties(deviceRo,deviceInfo);

            //Relation device
            RelationInfo relationInfo = new RelationInfo();
            BeanUtil.copyProperties(deviceInfo,relationInfo,"id","additionalInfo");

            //device
            Device device = new Device();
            if (attributeKvInfos!=null&&attributeKvInfos.size()!=0){
                device.setAttributeKvs(attributeKvInfos);
            }
            if (deviceInfo!=null){
                device.setDevice(deviceInfo);
            }
            if (relationInfo!=null){
                device.setRelation(relationInfo);
            }
            if (ObjectUtil.isNotEmpty(relationInfo)){
                device.setRelation(relationInfo);
            }
            deviceData.add(device);
        }
        pagination.setData(deviceData);
        return pagination;
    }

}
