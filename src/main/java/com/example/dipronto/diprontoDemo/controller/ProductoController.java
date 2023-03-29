package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/addProducto")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto addProducto(@RequestBody Producto producto ){
        return productoService.addProducto(producto);
    }
}
