package com.example.msventa.feing;

import com.example.msventa.Dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClienteFeing {

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarCLiente(@PathVariable Integer id);


}