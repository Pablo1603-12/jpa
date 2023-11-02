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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Puesto19
 */
@Entity
@Table(name = "Autores", schema = "gbp_operacional")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false)
    private long idAutor;

    @Column(name = "nombre_autor")
    private String nombreAutor;

    @Column(name = "apellidos_autor")
    private String apellidosAutor;

    @ManyToMany
    @JoinTable(
            name = "Rel_Autores_Libros",
            joinColumns = @JoinColumn(name = "id_autor"),
            inverseJoinColumns = @JoinColumn(name = "id_libro")
    )
    private Set<Libros> libros = new HashSet<>();
// Constructor, getters y setters

    public Autores() {
    }

    public Autores(String nombreAutor, String apellidosAutor) {

        this.nombreAutor = nombreAutor;
        this.apellidosAutor = apellidosAutor;
    }

}
