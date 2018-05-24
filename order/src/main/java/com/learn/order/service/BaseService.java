package com.learn.order.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 基类接口
 */
public interface BaseService<T> {
    T saveOrUpdate(T t);
    T delete(String id);
    T findOne(String id);
    List<T> findAll();
    Page<T> findByPage(Pageable page);
}