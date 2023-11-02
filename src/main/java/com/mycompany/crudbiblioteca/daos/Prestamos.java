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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;

/**
 *
 * @author Puesto19
 */

@Entity
@Table(name = "Prestamo", schema = "gbp_operacional")
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo", nullable = false)
    private long idPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libros libro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fch_inicio_prestamo")
    private Calendar fechaInicioPrestamo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fch_fin_prestamo")
    private Calendar fechaFinPrestamo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fch_entrega_prestamo")
    private Calendar fechaEntregaPrestamo;

    @ManyToOne
    @JoinColumn(name = "id_estado_prestamo")
    private EstadoPrestamo id_estado_prestamo;

    // Constructor, getters y setters

    public Prestamos() {
    }

    
    public Prestamos(Libros libro, Usuarios usuario, Calendar fechaInicioPrestamo, Calendar fechaFinPrestamo, Calendar fechaEntregaPrestamo, EstadoPrestamo id_estado_prestamo) {
 
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicioPrestamo = fechaInicioPrestamo;
        this.fechaFinPrestamo = fechaFinPrestamo;
        this.fechaEntregaPrestamo = fechaEntregaPrestamo;
        this.id_estado_prestamo = id_estado_prestamo;
    }
    
    
}
