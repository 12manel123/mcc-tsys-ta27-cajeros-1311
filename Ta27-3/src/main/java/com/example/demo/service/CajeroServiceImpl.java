package com.example.demo.service;

import com.example.demo.dao.ICajeroDAO;

import com.example.demo.dto.Cajero;
import com.example.demo.dto.Venta;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CajeroServiceImpl implements ICajeroService {

    private final ICajeroDAO cajeroDAO;
    private final IVentaService ventaService;
    
    public CajeroServiceImpl(ICajeroDAO cajeroDAO, IVentaService ventaService) {
        this.cajeroDAO = cajeroDAO;
        this.ventaService = ventaService;
    }

    @Override
    public Cajero getCajeroByCodigo(int codigo) {
        return cajeroDAO.findById(codigo).orElse(null);
    }

    @Override
    public List<Cajero> getAllCajeros() {
        return (List<Cajero>) cajeroDAO.findAll();
    }

    @Override
    public Cajero createCajero(Cajero cajero) {
        return cajeroDAO.save(cajero);
    }

    @Override
    public Cajero updateCajero(int codigo, Cajero cajero) {
        Cajero existingCajero = getCajeroByCodigo(codigo);
        if (existingCajero != null) {
            existingCajero.setNomApels(cajero.getNomApels());
            return cajeroDAO.save(existingCajero);
        }
        return null;
    }

    @Override
    public void deleteCajero(int codigo) {
        Cajero cajeroToDelete = getCajeroByCodigo(codigo);
        if (cajeroToDelete != null) {
            // Eliminar ventas asociadas al cajero antes de eliminar el cajero
            List<Venta> ventasDelCajero = ventaService.getVentasByCajero(codigo);
            for (Venta venta : ventasDelCajero) {
                ventaService.deleteVenta(venta.getCajero().getCodigo(), venta.getMaquina().getCodigo(), venta.getProducto().getCodigo());
            }
            // Eliminar el cajero
            cajeroDAO.deleteById(codigo);
        }
    }
}