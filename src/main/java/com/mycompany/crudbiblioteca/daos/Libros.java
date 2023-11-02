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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Puesto19
 */
@Entity
@Table(name = "Libros", schema = "gbp_operacional")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro", nullable = false)
    private long idLibro;

    @Column(name = "isbn_libro")
    private String isbnLibro;

    @Column(name = "titulo_libro")
    private String tituloLibro;

    @Column(name = "edicion_libro")
    private String edicionLibro;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editoriales id_editorial;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Generos id_genero;

    @ManyToOne
    @JoinColumn(name = "id_coleccion")
    private Colecciones id_coleccion;

    @ManyToMany(mappedBy = "libros")
    private Set<Autores> autores = new HashSet<>();
    // Constructor, getters y setters

    public Libros() {
    }

    public Libros(String isbnLibro, String tituloLibro, String edicionLibro, Editoriales id_editorial, Generos id_genero, Colecciones id_coleccion) {
    
        this.isbnLibro = isbnLibro;
        this.tituloLibro = tituloLibro;
        this.edicionLibro = edicionLibro;
        this.id_editorial = id_editorial;
        this.id_genero = id_genero;
        this.id_coleccion = id_coleccion;
    }

}
