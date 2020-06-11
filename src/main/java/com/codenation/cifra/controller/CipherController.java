package com.codenation.cifra.controller;

import com.codenation.cifra.model.CipherModel;
import com.codenation.cifra.model.Response;
import com.codenation.cifra.service.CipherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/cipher")
@Api(value = "Cifra de Cesar")
public class CipherController {

    @PostMapping(path="/encode")
    @ApiOperation(value = "Retorna a string decodificada")
    public ResponseEntity<?> encode (@RequestBody CipherModel cipher) {
        String res = new CipherService(cipher.getChangeFactor()).encode(cipher.getMessage());
        System.out.println(res);
        return new ResponseEntity<>(new Response(res), HttpStatus.OK);
    }

    @PostMapping(value="/decode", produces= MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retorna a string codificada")
    public ResponseEntity<?> decode (@RequestBody CipherModel cipher) {
        String res = new CipherService(cipher.getChangeFactor()).decode(cipher.getMessage());
        System.out.println("RES: " + res);
        return new ResponseEntity<>(new Response(res), HttpStatus.OK);
    }

    @PostMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Apenas para validar se o serviço está rodando")
    public ResponseEntity<?> postResponseJsonContent() {
        Response res = new Response("pong");
        return ResponseEntity.ok().body(res);
    }
}
