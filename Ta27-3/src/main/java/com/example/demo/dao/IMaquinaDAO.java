package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Maquina;

public interface IMaquinaDAO extends CrudRepository<Maquina, Integer> {
}
