package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoriaController {

    private final CategoriaService categoriaService;


    @PostMapping("/addCategoria")
    Categoria addCategoria(@RequestBody Categoria categoria){
        return this.categoriaService.addCategoria(categoria);
    }

    @GetMapping("/findAll")
    List<Categoria> findAll(){
        return this.categoriaService.findAll();
    }

    @DeleteMapping("/deleteCat/{id}")
    void deleteCat(@PathVariable("id")Long id){
        categoriaService.deleteCategoria(id);
    }


}
