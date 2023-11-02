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
@Table(name = "Editoriales", schema = "gbp_operacional")
public class Editoriales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial", nullable = false)
    private long idEditorial;

    @Column(name = "nombre_editorial")
    private String nombreEditorial;

    // Constructor, getters y setters

    public Editoriales() {
    }

    
    public Editoriales(String nombreEditorial) {
        
        this.nombreEditorial = nombreEditorial;
    }
    
    
}
