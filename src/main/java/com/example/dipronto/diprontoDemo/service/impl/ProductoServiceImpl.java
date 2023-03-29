package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.repository.DaoProducto;
import com.example.dipronto.diprontoDemo.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final DaoProducto daoProducto;

    public ProductoServiceImpl(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }


    @Override
    public Producto addProducto(Producto producto) {
        return daoProducto.save(producto);
    }

    @Override
    public List<Producto> verProducto() {
        return null;
    }


}
