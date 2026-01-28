package com.xjh.service;

import com.xjh.pojo.Clazz;
import com.xjh.pojo.PageResult;
import com.xjh.pojo.ClazzQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ballauma
 */
@Service
public interface ClazzService {
    public PageResult findAll(ClazzQueryParam studentPageResult);

    void deleteById(Integer id);

    void save(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAllClazz();
}
