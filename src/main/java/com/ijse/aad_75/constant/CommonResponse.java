package com.ijse.aad_75.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommonResponse {
    private int status;
    private Object object;
    private String message;

    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
