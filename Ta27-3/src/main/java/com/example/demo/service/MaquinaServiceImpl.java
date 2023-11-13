package com.example.demo.service;

import com.example.demo.dao.IMaquinaDAO;
import com.example.demo.dto.Maquina;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MaquinaServiceImpl implements IMaquinaService {

    private final IMaquinaDAO maquinaDAO;

    public MaquinaServiceImpl(IMaquinaDAO maquinaDAO) {
        this.maquinaDAO = maquinaDAO;
    }

    @Override
    public Maquina getMaquinaByCodigo(int codigo) {
        return maquinaDAO.findById(codigo).orElse(null);
    }

    @Override
    public List<Maquina> getAllMaquinas() {
        return (List<Maquina>) maquinaDAO.findAll();
    }

    @Override
    public Maquina createMaquina(Maquina maquina) {
        return maquinaDAO.save(maquina);
    }

    @Override
    public Maquina updateMaquina(int codigo, Maquina maquina) {
    	Maquina existingMaquina = getMaquinaByCodigo(codigo);
        if (existingMaquina != null) {
            existingMaquina.setPiso(maquina.getPiso());
            return maquinaDAO.save(existingMaquina);
        }
        return null;
    }

    @Override
    public void deleteMaquina(int codigo) {
        maquinaDAO.deleteById(codigo);
    }
}