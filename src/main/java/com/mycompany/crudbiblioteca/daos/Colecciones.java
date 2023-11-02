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
@Table(name = "Colecciones", schema = "gbp_operacional")
public class Colecciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coleccion", nullable = false)
    private long idColeccion;

    @Column(name = "nombre_coleccion")
    private String nombreColeccion;

    // Constructor, getters y setters
    public Colecciones() {
    }

    public Colecciones(String nombreColeccion) {

        this.nombreColeccion = nombreColeccion;
    }

}
