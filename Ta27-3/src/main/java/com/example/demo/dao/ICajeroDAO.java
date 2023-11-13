package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Cajero;

public interface ICajeroDAO extends CrudRepository<Cajero, Integer> {
}
