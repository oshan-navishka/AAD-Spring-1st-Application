package com.ijse.aad_75.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderDTO {
    private long orderId;
    private String orderName;
    private LocalDate orderDate;

    private long customerId;
    private String customerName;
}
