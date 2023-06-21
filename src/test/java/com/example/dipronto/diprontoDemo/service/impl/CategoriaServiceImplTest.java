package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.dto.TestCategoria;
import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceImplTest {

    @Mock
    private DaoCategoria daoCategoria;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Test
    void addCat() {
        Categoria cat = new Categoria();
        cat.setId(1L);
        cat.setNombre("Promociones Familiares");
        Mockito.when(daoCategoria.findByNombre(cat.getNombre())).thenReturn(null);
        Mockito.when(daoCategoria.save(ArgumentMatchers.any(Categoria.class))).thenReturn(cat);
        Assertions.assertDoesNotThrow(() -> {
            categoriaService.addCat(cat);
        });
    }

    @Test
    void addCatException() {
        Categoria cat = new Categoria();
        cat.setId(1L);
        cat.setNombre("Promociones Familiares");
        Mockito.when(daoCategoria.findByNombre(cat.getNombre())).thenReturn(cat);
        Assertions.assertThrows(CustomException.class, () ->
                categoriaService.addCat(cat));
    }

    @Test
    void findAllCat() {
        var categoriaList = TestCategoria.miCategoriaIterable();
        Mockito.when(daoCategoria.findAll()).thenReturn(categoriaList);
        categoriaService.findAllCat();
    }

    @Test
    void findAllCatException() {
        List<Categoria> categoriaList = new ArrayList<>();
        Mockito.when(daoCategoria.findAll()).thenReturn(categoriaList);
        Assertions.assertThrows(CustomException.class, () ->
                categoriaService.findAllCat());

    }

    @Test
    void findByIdCat() {
        Long id = 1L;
        Optional<Categoria> optionalList = Optional.of(TestCategoria.miCategoria());
        Mockito.when(daoCategoria.findById(id)).thenReturn(optionalList);
        categoriaService.findByIdCat(id);
    }

    @Test
    void deleteCat() {
        Long id = 1L;
        var categoria = TestCategoria.miCategoriaOptional();
        Mockito.when(daoCategoria.findById(id)).thenReturn((categoria));
        Categoria cat = categoria.get();
        daoCategoria.delete(cat);
        categoriaService.deleteCat(id);

    }

    @Test
    void updateCat() {
        Long id = 1L;
        var categoria = TestCategoria.miCategoria();
        Mockito.when(daoCategoria.findById(id)).thenReturn(Optional.of(categoria));
        Mockito.when(daoCategoria.save(ArgumentMatchers.any(Categoria.class))).thenReturn(categoria);
        categoriaService.updateCat(categoria);
    }


}