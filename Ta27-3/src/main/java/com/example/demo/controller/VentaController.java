package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Venta;
import com.example.demo.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }
    
    @GetMapping("/all")
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{cajero}/{maquina}/{producto}")
    public Venta getVenta(@PathVariable int cajero, @PathVariable int maquina, @PathVariable int producto) {
        return ventaService.getVentaByCajeroMaquinaProducto(cajero, maquina, producto);
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.createVenta(venta);
    }
    
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editVenta(@PathVariable Long id, @RequestBody Venta editedVenta) {
        if (!ventaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Venta updatedVenta = ventaService.editVenta(id, editedVenta);
        return ResponseEntity.ok("Venta actualizada correctamente: " + updatedVenta.getId());
    }

    @DeleteMapping("/{cajero}/{maquina}/{producto}")
    public void deleteVenta(@PathVariable int cajero, @PathVariable int maquina, @PathVariable int producto) {
        ventaService.deleteVenta(cajero, maquina, producto);
    }
}
