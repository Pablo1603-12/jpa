/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.crudbiblioteca.daos;

import jakarta.persistence.Column;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Puesto19
 */
@Entity
@Table(name = "\"Accesos\"", schema = "\"gbp_operacional\"")
public class Accesos {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acceso", nullable = false)
    private long id_acceso;

    @Column(name = "codigo_acceso", nullable = false)
    private String codigo_acceso;

    @Column(name = "descripcion_acceso")
    private String descripcion_acceso;

    @OneToMany(mappedBy = "acceso")
    List<Usuarios> usuariosConAcceso;

    //CONSTRUCTORES
    public Accesos() {
        super();
    }

    public Accesos(String codigo_acceso, String descripcion_acceso) {
        super();

        this.codigo_acceso = codigo_acceso;
        this.descripcion_acceso = descripcion_acceso;
    }

    public long getId_acceso() {
        return id_acceso;
    }

    public void setId_acceso(long id_acceso) {
        this.id_acceso = id_acceso;
    }

    public String getCodigo_acceso() {
        return codigo_acceso;
    }

    public void setCodigo_acceso(String codigo_acceso) {
        this.codigo_acceso = codigo_acceso;
    }

    public String getDescripcion_acceso() {
        return descripcion_acceso;
    }

    public void setDescripcion_acceso(String descripcion_acceso) {
        this.descripcion_acceso = descripcion_acceso;
    }

    public List<Usuarios> getUsuariosConAcceso() {
        return usuariosConAcceso;
    }

    public void setUsuariosConAcceso(List<Usuarios> usuariosConAcceso) {
        this.usuariosConAcceso = usuariosConAcceso;
    }

    
    
}
