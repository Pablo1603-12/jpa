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

@Entity
@Table(name = "Usuarios", schema = "gbp_operacional")
public class Usuarios {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

    @Column(name = "dni_usuario", nullable = false)
    private String dniUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "apellidos_usuario")
    private String apellidosUsuario;

    @Column(name = "tlf_usuario")
    private String tlfUsuario;

    @Column(name = "email_usuario")
    private String emailUsuario;

    @Column(name = "clave_usuario")
    private String claveUsuario;

    @Column(name = "estaBloqueado_usuario")
    private boolean estaBloqueadoUsuario;

    @Column(name = "fch_fin_bloqueo_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fchFinBloqueo;

    @Column(name = "fch_alta_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fchAltaUsuario;

    @Column(name = "fch_baja_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fchBajaUsuario;

    /*@Column(name="id_acceso")
	private long idAcceso;*/
    @ManyToOne
    @JoinColumn(name = "id_acceso")
    Accesos acceso;

    //CONSTRUCTORES
    public Usuarios() {
        super();
    }

    public Usuarios(String dniUsuario, String nombreUsuario, String apellidosUsuario, String tlfUsuario,
            String emailUsuario, String claveUsuario, boolean estaBloqueadoUsuario, Calendar fchFinBloqueo,
            Calendar fchAltaUsuario, Calendar fchBajaUsuario, Accesos acceso) {
        super();
        this.dniUsuario = dniUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.tlfUsuario = tlfUsuario;
        this.emailUsuario = emailUsuario;
        this.claveUsuario = claveUsuario;
        this.estaBloqueadoUsuario = estaBloqueadoUsuario;
        this.fchFinBloqueo = fchFinBloqueo;
        this.fchAltaUsuario = fchAltaUsuario;
        this.fchBajaUsuario = fchBajaUsuario;
        this.acceso = acceso;
    }

}
