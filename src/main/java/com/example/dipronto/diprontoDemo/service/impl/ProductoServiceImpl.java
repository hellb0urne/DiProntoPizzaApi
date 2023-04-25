package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.repository.DaoProducto;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import com.example.dipronto.diprontoDemo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final DaoProducto daoProducto;
    private final CategoriaService categoriaService;

    @Override
    public Producto addPro(Producto producto) {
        Optional<Categoria> categoria = this.categoriaService.findByIdCat(producto.getCategoria());
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
    public List<Producto> findAllPro() {
        return (List<Producto>) daoProducto.findAll();
    }

    @Override
    public Producto findByIdPro(Long id) {
        return daoProducto.findById(id).orElseThrow(() -> new CustomException("Categoria no existe", HttpStatus.BAD_REQUEST));

    }

    @Override
    public void deletePro(Long id) {
        Producto p = findByIdPro(id);
        this.daoProducto.delete(p);

    }

    @Override
    public Producto updatePro(Producto producto) {
        Producto p = findByIdPro(producto.getId());
        if (p != null) {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setCategoria(producto.getCategoria());
            this.daoProducto.save(p);
        }
        return p;
    }
}
