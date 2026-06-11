package com.ijse.aad_75.service;

import com.ijse.aad_75.dto.OrdersDTO;
import com.ijse.aad_75.dto.Response.GetOrderDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrdersService {

    void saveOrders(OrdersDTO ordersDTO);

    List<OrdersDTO> getAllOrdersByName(OrdersDTO ordersDTO);

    List<OrdersDTO> getAllOrdersByDate(OrdersDTO ordersDTO);

    List<OrdersDTO> filterOrders(String orderName, LocalDate orderDate);

    public GetOrderDTO getOrderDetails(long orderId);
}
