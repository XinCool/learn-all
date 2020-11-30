package com.example.ddd.domain.device.repository;

import com.example.ddd.domain.device.vo.RelationInfo;

/**
 * @author Cool
 * @create 2020-11-16
 */
public interface IRelationRepository {
    RelationInfo findParentByToId(String toId, String fromType,String toType,String relationType,String relationTypeGroup);


}
