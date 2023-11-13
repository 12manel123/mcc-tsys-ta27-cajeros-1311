package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;  // Cambié el nombre de id a codigo

    @Column(name = "nomApels")
    private String nomApels;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cajero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas;

    public Cajero() {
    }

    public Cajero(String nomApels) {
        this.nomApels = nomApels;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomApels() {
        return nomApels;
    }

    public void setNomApels(String nomApels) {
        this.nomApels = nomApels;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "codigo=" + codigo +
                ", nomApels='" + nomApels + '\'' +
                ", ventas=" + ventas +
                '}';
    }
}