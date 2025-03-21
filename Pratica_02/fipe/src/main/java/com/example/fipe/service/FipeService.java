package com.example.fipe.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class FipeService {

    private Object consultarURL(String apiUrl) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(apiUrl, Object.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return Map.of("erro", "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode());
        }
    }

    public Object consultarMarcas() {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }

    public Object consultarModelos(int id) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + id + "/modelos");
    }

    public Object consultarAnos(int marca, int modelo) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/" + modelo + "/anos");
    }

    public Object consultarValor(int marca, int modelo, String ano) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/" + modelo + "/anos/" + ano);
    }
}


//Marcas: http://localhost:8080/marcas
//Modelos: http://localhost:8080/modelos/{idDaMarca} (substitua {idDaMarca} pelo ID de uma marca válida, como 59 para Fiat).
//Anos: http://localhost:8080/anos/{idDaMarca}/{idDoModelo}.
//Valor: http://localhost:8080/valor/{idDaMarca}/{idDoModelo}/{ano}.
