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
@Table(name = "EstadoPrestamo", schema = "gbp_operacional")
public class EstadoPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_prestamo", nullable = false)
    private long idEstadoPrestamo;

    @Column(name = "codigo_estado_prestamo")
    private String codigoEstadoPrestamo;

    @Column(name = "descripcion_estado_prestamo")
    private String descripcionEstadoPrestamo;

    // Constructor, getters y setters

    public EstadoPrestamo() {
    }

    public EstadoPrestamo(String codigoEstadoPrestamo, String descripcionEstadoPrestamo) {
     
        this.codigoEstadoPrestamo = codigoEstadoPrestamo;
        this.descripcionEstadoPrestamo = descripcionEstadoPrestamo;
    }
    
    
}

