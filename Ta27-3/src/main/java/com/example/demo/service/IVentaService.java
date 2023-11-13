package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {
    Venta getVentaByCajeroMaquinaProducto(int cajero, int maquina, int producto);
    Venta createVenta(Venta venta);
    void deleteVenta(int cajero, int maquina, int producto);
    List<Venta> getVentasByCajero(int cajeroCodigo);
	List<Venta> getAllVentas();
	Venta editVenta(Long id, Venta editedVenta);
	boolean existsById(Long id);
}