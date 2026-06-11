package com.ijse.aad_75.repository;

import com.ijse.aad_75.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
