package com.xjh.mapper;

import com.xjh.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ballauma
 */
@Mapper
public interface EmpExprMapper {


    /**
     * 批量保存员工的工作经历信息
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> ids);
}
