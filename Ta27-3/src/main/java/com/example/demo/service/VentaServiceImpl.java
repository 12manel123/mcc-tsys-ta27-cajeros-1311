package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

    private final IVentaDAO ventaDAO;

    public VentaServiceImpl(IVentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }
    
    @Override
    public List<Venta> getAllVentas() {
        return (List<Venta>) ventaDAO.findAll();
    }

    @Override
    public Venta getVentaByCajeroMaquinaProducto(int cajero, int maquina, int producto) {
        return ventaDAO.findByCajeroCodigoAndMaquinaCodigoAndProductoCodigo(cajero, maquina, producto).orElse(null);
    }

    @Override
    public Venta createVenta(Venta venta) {
        return ventaDAO.save(venta);
    }
    @Override
    public boolean existsById(Long id) {
        return ventaDAO.existsById(id);
    }

    @Override
    public Venta editVenta(Long id, Venta editedVenta) {
        Optional<Venta> existingVentaOptional = ventaDAO.findById(id);

        if (existingVentaOptional.isPresent()) {
            Venta existingVenta = existingVentaOptional.get();
            return ventaDAO.save(existingVenta);
        } else {
            return null;
        }
    }

    @Override
    public void deleteVenta(int cajero, int maquina, int producto) {
        Venta ventaToDelete = getVentaByCajeroMaquinaProducto(cajero, maquina, producto);
        if (ventaToDelete != null) {
            ventaDAO.delete(ventaToDelete);
        }
    }

    @Override
    public List<Venta> getVentasByCajero(int cajeroCodigo) {
        return ventaDAO.findAllByCajeroCodigo(cajeroCodigo);
    }
}