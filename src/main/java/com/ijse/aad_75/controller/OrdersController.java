package com.ijse.aad_75.controller;

import com.ijse.aad_75.constant.CommonResponse;
import com.ijse.aad_75.dto.OrdersDTO;
import com.ijse.aad_75.service.OrdersService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.ijse.aad_75.constant.ResponseConde.OPERATION_SUCCESS;
import static com.ijse.aad_75.constant.ResponseMassage.SUCCESS_MASSAGE;

@RestController
@RequestMapping("v1/orders")
public class OrdersController {
    private final OrdersService ordersService;
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveOrders(@RequestBody OrdersDTO ordersDTO){
        ordersService.saveOrders(ordersDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MASSAGE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllOrdersByName(@RequestBody OrdersDTO ordersDTO){
        return new CommonResponse(OPERATION_SUCCESS, ordersService.getAllOrdersByName(ordersDTO), SUCCESS_MASSAGE);
    }

    @GetMapping(value = "/dte", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllOrdersByDate(@RequestBody OrdersDTO ordersDTO){
        return new CommonResponse(OPERATION_SUCCESS, ordersService.getAllOrdersByName(ordersDTO), SUCCESS_MASSAGE);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterOrders(
            @RequestParam(value = "orderName", required = false) String orderName, LocalDate orderDate){
        List<OrdersDTO> ordersDTOS = ordersService.filterOrders(orderName, orderDate);
        return new CommonResponse(OPERATION_SUCCESS, ordersDTOS, SUCCESS_MASSAGE);
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getOrderDetails(@PathVariable long orderId) {
        return new CommonResponse(
                OPERATION_SUCCESS,
                ordersService.getOrderDetails(orderId),
                SUCCESS_MASSAGE
        );
    }
}
