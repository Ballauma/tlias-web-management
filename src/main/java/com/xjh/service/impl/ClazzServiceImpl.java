package com.xjh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xjh.mapper.ClazzMapper;
import com.xjh.pojo.Clazz;
import com.xjh.pojo.PageResult;
import com.xjh.pojo.ClazzQueryParam;
import com.xjh.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ballauma
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;


    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> findAllClazz() {
        return clazzMapper.findAllClazz();
    }

    @Override
    public Clazz findById(Integer id) {
        return clazzMapper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public PageResult<Clazz> findAll(ClazzQueryParam studentPageResult) {
        PageHelper.startPage(studentPageResult.getPage(), studentPageResult.getPageSize());
        List<Clazz> s = clazzMapper.findAll();
        Page<Clazz> p = (Page<Clazz>) s;

        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }
}
