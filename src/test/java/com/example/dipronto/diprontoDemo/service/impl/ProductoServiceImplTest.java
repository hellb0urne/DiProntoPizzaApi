package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.dto.TestCategoria;
import com.example.dipronto.diprontoDemo.dto.TestProducto;
import com.example.dipronto.diprontoDemo.entity.Producto;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.repository.DaoProducto;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTest {

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Mock
    private DaoProducto daoProducto;

    @Mock
    private DaoCategoria daoCategoria;

    @Mock
    private CategoriaService categoriaService;


    @Test
    void addPro() {
        var producto = TestProducto.miProducto();
        var categoria = TestCategoria.miCategoriaOptional();
        Mockito.when(categoriaService.findByIdCat(producto.getCategoria())).thenReturn(categoria);
        Mockito.when(daoProducto.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);
        productoService.addPro(producto);
    }

    /*
    @Test
    void addProException() {
        var producto = TestProducto.miProducto2();
        ;
        Mockito.when(daoCategoria.findById(producto.getCategoria())).thenReturn(null);
        Assertions.assertThrows(CustomException.class, () -> productoService.addPro(producto));

    }

     */


    @Test
    void findAllPro() {
        var listaProductos = TestProducto.miListaProductos();
        Mockito.when(daoProducto.findAll()).thenReturn(listaProductos);
        productoService.findAllPro();
    }

    @Test
    void findAllProException() {
        var miListaProducto = daoProducto.findAll();
        Mockito.when(daoProducto.findAll()).thenReturn(miListaProducto);
        Assertions.assertThrows(CustomException.class, () -> productoService.findAllPro());


    }


    @Test
    void deletePro() {
        Long id = 1L;
        var producto = TestProducto.miProductoOptional();
        Mockito.when(daoProducto.findById(id)).thenReturn(producto);
        var pro = producto.get();
        Mockito.doNothing().when(daoProducto).delete(pro);
        productoService.deletePro(id);

    }

    @Test
    void deleteProException() {
        Long id = 1L;
        Optional<Producto> optionalProducto = daoProducto.findById(id);
        Mockito.when(daoProducto.findById(id)).thenReturn(optionalProducto);
        Assertions.assertThrows(CustomException.class, () -> productoService.deletePro(id));
    }

    @Test
    void updatePro() {
        var producto = TestProducto.miProducto();
        var categoriaOptional = TestCategoria.miCategoriaOptional();
        var productoOptional = TestProducto.miProductoOptional();
        Mockito.when(daoCategoria.findById(producto.getCategoria())).thenReturn(categoriaOptional);
        Mockito.when(daoProducto.findById(producto.getId())).thenReturn(productoOptional);
        Mockito.when(daoProducto.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);
        productoService.updatePro(producto);
    }

    @Test
    void updateProException() {
        Producto producto = new Producto();
        var categoriaOptional = daoCategoria.findById(producto.getId());
        var productoOptional = daoProducto.findById(producto.getCategoria());
        Mockito.when(daoCategoria.findById(producto.getCategoria())).thenReturn(categoriaOptional);
        Mockito.when(daoProducto.findById(producto.getId())).thenReturn(productoOptional);
        Assertions.assertThrows(CustomException.class, () -> productoService.updatePro(producto));
    }
}