package com.ijse.aad_75.service.impl;

import com.ijse.aad_75.dto.OrdersDTO;
import com.ijse.aad_75.dto.Response.GetOrderDTO;
import com.ijse.aad_75.entity.Customer;
import com.ijse.aad_75.entity.Orders;
import com.ijse.aad_75.repository.CustomerRepository;
import com.ijse.aad_75.repository.OrdersRepository;
import com.ijse.aad_75.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    public OrdersServiceImpl(OrdersRepository ordersRepository, CustomerRepository customerRepository) {
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveOrders(OrdersDTO ordersDTO) {
        log.info("Execute method saveOrders");

        if (ordersDTO.getOrderName() == null) {
            throw new RuntimeException("Order Name is null");
        }
        try{
            Orders orders = new Orders();
            orders.setOrderName(ordersDTO.getOrderName());
            orders.setOrderDate(ordersDTO.getOrderDate());

            Optional<Customer> optionalCustomer = customerRepository.findById(ordersDTO.getCustomerId());
            if (optionalCustomer.isEmpty())
                throw new RuntimeException("Sorry, related customer is not found");
                Customer customer = optionalCustomer.get();
                orders.setCustomer(customer);
                ordersRepository.save(orders);
        }catch (Exception e){
            log.error("Error while saving Orders"+ e.getMessage());
        }
    }

    @Override
    public List<OrdersDTO> getAllOrdersByName(OrdersDTO ordersDTO) {
        log.info("Execute method getAllOrdersByName");

        if (ordersDTO.getOrderName() == null) {
            throw new RuntimeException("Order Name is null");
        }
        try {
            List<OrdersDTO> responsList = new ArrayList<>();
            List<Orders> ordersList = ordersRepository.findAll();

            for (Orders orders : ordersList) {
                OrdersDTO ordersDTO1 = new OrdersDTO();
                ordersDTO1.setOrderName(orders.getOrderName());
                responsList.add(ordersDTO1);
            }
            return responsList;
        }catch (Exception e){
            log.error("Error while fetching all orders"+ e.getMessage());
            throw e;
        }
    }

    @Override
    public List<OrdersDTO> getAllOrdersByDate(OrdersDTO ordersDTO) {
        log.info("Execute method getAllOrdersByDate");
        try {
            List<OrdersDTO> responsList = new ArrayList<>();
            List<Orders> ordersList = ordersRepository.findAll();

            for (Orders orders : ordersList) {
                OrdersDTO ordersDTO1 = new OrdersDTO();
                ordersDTO1.setOrderDate(orders.getOrderDate());
                responsList.add(ordersDTO1);
            }
            return responsList;
        }catch (Exception e){
            log.error("Error while fetching all orders"+ e.getMessage());
            throw e;
        }
    }

    @Override
    public List<OrdersDTO> filterOrders(String orderName, LocalDate orderDate) {
        log.info("Execute method filterOrders, orderName: {}, orderDate: {}", orderName, orderDate);
        try{
            List<OrdersDTO> responsList = new ArrayList<>();
            List<Orders> ordersList = ordersRepository.findAll();
            for (Orders orders : ordersList) {
                OrdersDTO ordersDTO1 = new OrdersDTO();
                ordersDTO1.setOrderName(orders.getOrderName());
                ordersDTO1.setOrderDate(orders.getOrderDate());
                responsList.add(ordersDTO1);
            }
            return responsList;
        }catch (Exception e){
            log.error("Error while fetching all orders"+ e.getMessage());
            throw e;
        }
    }

    @Override
    public GetOrderDTO getOrderDetails(long orderId) {
        log.info("Execute method getOrderDetails, orderId: {}", orderId);

        Optional<Orders> optionalOrders = ordersRepository.findById(orderId);
        if (optionalOrders.isEmpty())
            throw new RuntimeException("Sorry, related order is not found");

        Orders orders = optionalOrders.get();
        GetOrderDTO getOrderDTO = new GetOrderDTO();
        getOrderDTO.setOrderId(orders.getOrderId());
        getOrderDTO.setOrderName(orders.getOrderName());
        getOrderDTO.setOrderDate(orders.getOrderDate());
        getOrderDTO.setCustomerId(orders.getCustomer().getCustomerId());
        getOrderDTO.setCustomerName(orders.getCustomer().getCustomerName());
        return getOrderDTO;
    }

}
