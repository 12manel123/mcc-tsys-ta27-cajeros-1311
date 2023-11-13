package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Cajero;
import com.example.demo.service.ICajeroService;

@RestController
@RequestMapping("/cajeros")
public class CajeroController {

    private final ICajeroService cajeroService;
    
    public CajeroController(ICajeroService cajeroService) {
        this.cajeroService = cajeroService;
    }
    @GetMapping("/all")
    public List<Cajero> getAllCajeros() {
        return cajeroService.getAllCajeros();
    }

    @GetMapping("/{codigo}")
    public Cajero getCajero(@PathVariable int codigo) {
        return cajeroService.getCajeroByCodigo(codigo);
    }

    @PostMapping
    public Cajero createCajero(@RequestBody Cajero cajero) {
        return cajeroService.createCajero(cajero);
    }

    @PutMapping("/{codigo}")
    public Cajero updateCajero(@PathVariable int codigo, @RequestBody Cajero cajero) {
        return cajeroService.updateCajero(codigo, cajero);
    }

    @DeleteMapping("/{codigo}")
    public void deleteCajero(@PathVariable int codigo) {
        cajeroService.deleteCajero(codigo);
    }
}
