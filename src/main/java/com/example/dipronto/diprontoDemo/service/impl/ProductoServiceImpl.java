package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.repository.DaoProducto;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import com.example.dipronto.diprontoDemo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final DaoProducto daoProducto;
    private final DaoCategoria daoCategoria;
    private final CategoriaService categoriaService;

    @Transactional
    @Override
    public Producto addPro(Producto producto) {
        categoriaService.findByIdCat(producto.getCategoria());
        return daoProducto.save(producto);
    }


    @Override
    public Iterable<Producto> findAllPro() {
        var productoList = daoProducto.findAll();
        if (!productoList.iterator().hasNext()) {
            throw new CustomException("Lista vacia", HttpStatus.NO_CONTENT);
        }
        return daoProducto.findAll();
    }


    @Override
    public void deletePro(Long id) {
        var producto = daoProducto.findById(id);
        if (producto.isEmpty()) {
            throw new CustomException("id producto no existe", HttpStatus.CONFLICT);
        }
        Producto pro = producto.get();
        daoProducto.delete(pro);

    }

    @Override
    public Producto updatePro(Producto producto) {
        var categoria = daoCategoria.findById(producto.getCategoria());
        var pro = daoProducto.findById(producto.getId());
        if (categoria.isEmpty() || pro.isEmpty()) {
            throw new CustomException("verificar ids!", HttpStatus.CONFLICT);
        }
        return daoProducto.save(producto);

    }

}
