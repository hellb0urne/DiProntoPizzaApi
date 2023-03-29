package com.example.dipronto.diprontoDemo.service;

import com.example.dipronto.diprontoDemo.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoService {
    Producto addProducto(Producto producto);
    List<Producto> verProducto();
}
