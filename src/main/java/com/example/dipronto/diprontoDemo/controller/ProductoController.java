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

    @GetMapping("/verProductos")
    public Iterable<Producto> findAllProduct() {
        return this.productoService.findAllPro();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/agregarProducto")
    public Producto addProducto(@RequestBody Producto producto){
        return productoService.addPro(producto);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/actualizarProducto")
    public Producto udpateProducto(@RequestBody Producto producto) {
        return this.productoService.updatePro(producto);
    }

    @DeleteMapping("/borrarProducto/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productoService.deletePro(id);
    }

}
