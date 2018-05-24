package com.learn.order.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.order.entity.OrderDetail;


public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String OrderId);
}
