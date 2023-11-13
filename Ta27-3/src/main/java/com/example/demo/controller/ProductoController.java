package com.example.demo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Producto;
import com.example.demo.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }
    
    @GetMapping("/all")
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{codigo}")
    public Producto getProducto(@PathVariable int codigo) {
        return productoService.getProductoByCodigo(codigo);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{codigo}")
    public Producto updateProducto(@PathVariable int codigo, @RequestBody Producto producto) {
        return productoService.updateProducto(codigo, producto);
    }

    @DeleteMapping("/{codigo}")
    public void deleteProducto(@PathVariable int codigo) {
        productoService.deleteProducto(codigo);
    }
}