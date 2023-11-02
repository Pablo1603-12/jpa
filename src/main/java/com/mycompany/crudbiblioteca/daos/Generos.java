/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudbiblioteca.daos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Puesto19
 */
@Entity
@Table(name = "Generos", schema = "gbp_operacional")
public class Generos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero", nullable = false)
    private long idGenero;

    @Column(name = "nombre_genero")
    private String nombreGenero;

    @Column(name = "descripcion_genero")
    private String descripcionGenero;

    public Generos(String nombreGenero, String descripcionGenero) {
       
        this.nombreGenero = nombreGenero;
        this.descripcionGenero = descripcionGenero;
    }

    public Generos() {
    }

    
}
