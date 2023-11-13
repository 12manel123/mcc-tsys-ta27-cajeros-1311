package com.example.demo.service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductoDAO productoDAO;

    public ProductoServiceImpl(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    @Override
    public Producto getProductoByCodigo(int codigo) {
        return productoDAO.findById(codigo).orElse(null);
    }

    @Override
    public List<Producto> getAllProductos() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoDAO.save(producto);
    }

    @Override
    public Producto updateProducto(int codigo, Producto producto) {
        Producto existingProducto = getProductoByCodigo(codigo);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setPrecio(producto.getPrecio());
            return productoDAO.save(existingProducto);
        }
        return null;
    }

    @Override
    public void deleteProducto(int codigo) {
        productoDAO.deleteById(codigo);
    }
}