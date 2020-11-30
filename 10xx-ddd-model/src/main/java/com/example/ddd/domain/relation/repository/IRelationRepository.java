package com.example.ddd.domain.relation.repository;


import com.example.ddd.domain.relation.entities.RelationInfo;

/**
 * @author Cool
 * @create 2020-11-16
 */
public interface IRelationRepository {

    /**
     * 通过toId及其他属性查询
     * @param toId
     * @param fromType
     * @param toType
     * @param relationType
     * @param relationTypeGroup
     * @return
     */
    RelationInfo findByToId(String toId, String fromType, String toType, String relationType, String relationTypeGroup);

    /**
     * 通过fromId及其他属性查询
     * @param fromId
     * @param fromType
     * @param toType
     * @param relationType
     * @param relationTypeGroup
     * @return
     */
    RelationInfo findByFromId(String fromId, String fromType, String toType, String relationType, String relationTypeGroup);


}
