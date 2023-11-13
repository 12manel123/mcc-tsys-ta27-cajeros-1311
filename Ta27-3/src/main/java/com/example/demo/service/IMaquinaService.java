package com.example.demo.service;

import com.example.demo.dto.Maquina;

import java.util.List;

public interface IMaquinaService {
    Maquina getMaquinaByCodigo(int codigo);
    List<Maquina> getAllMaquinas();
    Maquina createMaquina(Maquina maquina);
    Maquina updateMaquina(int codigo, Maquina maquina);
    void deleteMaquina(int codigo);
}