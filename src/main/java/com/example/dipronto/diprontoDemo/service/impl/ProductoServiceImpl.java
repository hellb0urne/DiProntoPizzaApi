package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.repository.DaoProducto;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import com.example.dipronto.diprontoDemo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final DaoProducto daoProducto;
    private final CategoriaService categoriaService;

    @Override
    public Producto addProducto(Producto producto) {
        Optional<Categoria> categoria = this.categoriaService.findById(Long.valueOf(producto.getCategoria()));
        Categoria cat = categoria.get();
        Producto p = new Producto();
        p.setId(producto.getId());
        p.setNombre(producto.getNombre());
        p.setPrecio(producto.getPrecio());
        p.setCategoria(cat.getId());
        daoProducto.save(p);
        return p;
    }

    @Override
    public List<Producto> verProducto() {
        return null;
    }


}
