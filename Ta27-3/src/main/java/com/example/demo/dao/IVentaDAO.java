package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Venta;

public interface IVentaDAO extends CrudRepository<Venta, Long>{
	Optional<Venta> findByCajeroCodigoAndMaquinaCodigoAndProductoCodigo(int cajero, int maquina, int producto);
    List<Venta> findAllByCajeroCodigo(int cajeroCodigo);
}
