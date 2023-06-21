package com.example.dipronto.diprontoDemo.dto;

import com.example.dipronto.diprontoDemo.entity.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestProducto {

    public static Producto miProducto(){
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Pizza 37 cm");
        producto.setPrecio(8500);
        producto.setCategoria(1L);
        return producto;
    }
    public static Producto miProducto2(){
        Producto producto = new Producto();
        producto.setId(2L);
        producto.setNombre("Pizza 37 cm");
        producto.setPrecio(8500);
        producto.setCategoria(1L);
        return producto;
    }

    public static Optional<Producto> miProductoOptional(){
        Optional<Producto>optionalProducto = Optional.of(miProducto());
        return optionalProducto;
    }


    public static List<Producto> miListaProductos(){
        List<Producto> productosList = new ArrayList<>();
        productosList.add(miProducto());
        return productosList;
    }

}
