package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.dto.TestCategoria;
import com.example.dipronto.diprontoDemo.dto.TestProducto;
import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.service.impl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductoControllerTest {

    @InjectMocks
    private ProductoController productoController;

    @Mock
    private ProductoServiceImpl productoService;

    @Test
    void addProducto() {
        var producto = TestProducto.miProducto();
        Mockito.when(productoService.addPro(producto)).thenReturn(producto);
        productoController.addProducto(producto);

    }

    @Test
    void findAllProduct() {
        var productoList = TestProducto.miListaProductos();
        Mockito.when(productoService.findAllPro()).thenReturn(productoList);
        productoController.findAllProduct();
    }

    @Test
    void udpateProducto() {
        var producto = TestProducto.miProducto();
        Mockito.when(productoService.updatePro(producto)).thenReturn(producto);
        productoController.udpateProducto(producto);
    }

    @Test
    void deleteProduct() {
        var producto = TestProducto.miProducto();
        Long id = 1L;
        productoController.deleteProduct(id);
    }
}