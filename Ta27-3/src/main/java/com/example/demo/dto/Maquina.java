package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "piso")
    private int piso;
    
    @JsonIgnore
    @OneToMany(mappedBy = "maquina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas;

    public Maquina() {
    }

    public Maquina(int piso) {
        this.piso = piso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "MaquinaRegistradora{" +
                "codigo=" + codigo +
                ", piso=" + piso +
                ", ventas=" + ventas +
                '}';
    }
}
