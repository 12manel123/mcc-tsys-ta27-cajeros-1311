package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.example.demo.dto.Maquina;
import com.example.demo.service.IMaquinaService;

@RestController
@RequestMapping("/maquinas")
public class MaquinaController {

 private final IMaquinaService maquinaService;
 
 public MaquinaController(IMaquinaService maquinaService) {
     this.maquinaService = maquinaService;
 }
 
 @GetMapping("/all")
 public List<Maquina> getAllMaquinasRegistradoras() {
     return maquinaService.getAllMaquinas();
 }

 @GetMapping("/{codigo}")
 public Maquina getMaquina(@PathVariable int codigo) {
     return maquinaService.getMaquinaByCodigo(codigo);
 }

 @PostMapping
 public Maquina createMaquina(@RequestBody Maquina maquina) {
     return maquinaService.createMaquina(maquina);
 }

 @PutMapping("/{codigo}")
 public Maquina updateMaquina(@PathVariable int codigo, @RequestBody Maquina maquina) {
     return maquinaService.updateMaquina(codigo, maquina);
 }

 @DeleteMapping("/{codigo}")
 public void deleteMaquina(@PathVariable int codigo) {
     maquinaService.deleteMaquina(codigo);
 }
}
