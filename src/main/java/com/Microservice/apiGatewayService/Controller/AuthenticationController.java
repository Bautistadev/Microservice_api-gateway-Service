package com.Microservice.apiGatewayService.Controller;

import com.Microservice.apiGatewayService.Entity.LoginRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    @Value("${token_endpoint}")
    private String token_Endpoint;

    /**
     * @Operation: login
     * @Param: login request object
     * @Return: string token
     * */
    @PostMapping("/login")
    public ResponseEntity<String> generateToken(@Valid @RequestBody LoginRequest loginRequest){

        /**
         * DEFINIMOS UNA CABEZERA
         * */
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        /**
         * PASAMOS LOS PARAMETROS DEL USUARIO (NOMBRE DE USUARIO Y ONTRASEÑA) Y CREAMOS LA PETICION
         * */
        String body="grant_type=client_credentials&client_id=" + loginRequest.getClientId() + "&client_secret=" + loginRequest.getClientSecretKey();
        HttpEntity<String> request = new HttpEntity<>(body,headers);

        /**
         * GNERAMOS EL TOKEN PASANDO LA URL
         * */
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(token_Endpoint,request, String.class);
        if(response.getStatusCodeValue() == 200){
            /**
             * RETORNAMOS EL TOKEN
             * */
            String token = response.getBody();
            return ResponseEntity.ok(token);
        }else{
            return ResponseEntity.badRequest().body("Error al obtener el token");
        }
    }
}
