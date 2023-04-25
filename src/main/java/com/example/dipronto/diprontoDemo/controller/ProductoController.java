package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/addProducto")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addPro(producto);
    }

    @GetMapping("/findAllProduct")
    public List<Producto> findAllProduct() {
        return this.productoService.findAllPro();
    }

    @PutMapping("/updateProduct")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Producto udpateProducto(@RequestBody Producto producto) {
        try {
            return this.productoService.updatePro(producto);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productoService.deletePro(id);
    }


}
