package com.Microservice.apiGatewayService.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequest {

    private String clientId;
    private String clientSecretKey;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "clientId='" + clientId + '\'' +
                ", clientSecretKey='" + clientSecretKey + '\'' +
                '}';
    }
}
