package com.ijse.aad_75.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private long orderId;
    private String orderName;
    private LocalDate orderDate;

    private long customerId;
}
