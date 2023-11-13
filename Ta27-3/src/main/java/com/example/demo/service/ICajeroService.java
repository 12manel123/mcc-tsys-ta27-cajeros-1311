package com.example.demo.service;

import com.example.demo.dto.Cajero;

import java.util.List;

public interface ICajeroService {
    Cajero getCajeroByCodigo(int codigo);
    List<Cajero> getAllCajeros();
    Cajero createCajero(Cajero cajero);
    Cajero updateCajero(int codigo, Cajero cajero);
    void deleteCajero(int codigo);
}
