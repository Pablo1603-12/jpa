package com.mycompany.crudbiblioteca;

import com.mycompany.crudbiblioteca.daos.Accesos;
import com.mycompany.crudbiblioteca.daos.Colecciones;
import com.mycompany.crudbiblioteca.daos.Editoriales;
import com.mycompany.crudbiblioteca.daos.EstadoPrestamo;
import com.mycompany.crudbiblioteca.daos.Generos;
import com.mycompany.crudbiblioteca.daos.Libros;
import com.mycompany.crudbiblioteca.daos.Prestamos;
import com.mycompany.crudbiblioteca.daos.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Calendar;

public class Controller {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Operaciones CRUD para la clase Accesos
        Accesos acceso = new Accesos("Usu", "Acceso Usuario Biblioteca");
        em.persist(acceso);

        // Operaciones CRUD para otras clases
        //crear un Usuario
        Calendar fchFinBloqueo = Calendar.getInstance();
        fchFinBloqueo.set(2023, Calendar.DECEMBER, 31);

        Calendar fchAltaUsuario = Calendar.getInstance();
        fchAltaUsuario.set(2022, Calendar.NOVEMBER, 1);

        Calendar fchBajaUsuario = Calendar.getInstance();
        fchBajaUsuario.set(2023, Calendar.OCTOBER, 15);

        Usuarios usuario = new Usuarios(
                "12345678L",
                "Pablo",
                "Marquinez",
                "654987312",
                "pmj3@gmail.com",
                "1234",
                true,
                fchFinBloqueo,
                fchAltaUsuario,
                fchBajaUsuario,
                acceso);
        em.persist(usuario);

        //Crear editorial
        Editoriales editorial = new Editoriales("SM");
        em.persist(editorial);

        //Crear genero
        Generos genero = new Generos("Drama", "Drama");
        em.persist(genero);

        //Crear coleccion
        Colecciones coleccion = new Colecciones("Prueba");
        em.persist(coleccion);

        // Obtener el Libro dentro de la transacción
        Libros libro = em.find(Libros.class, 1);

        //crear estado prestamo
        EstadoPrestamo estadoPrestamo = new EstadoPrestamo(
                "",
                "Prestado");
        em.persist(estadoPrestamo);

        // Fechas Prestamo
        Calendar fchFinPrestamo = Calendar.getInstance();
        fchFinPrestamo.set(2023, Calendar.DECEMBER, 31);

        Calendar fchInicioPrestamo = Calendar.getInstance();
        fchInicioPrestamo.set(2022, Calendar.NOVEMBER, 1);

        Calendar fchEntregaPrestamo = Calendar.getInstance();
        fchEntregaPrestamo.set(2023, Calendar.OCTOBER, 15);

        //Crear un Prestamo
        Prestamos prestamo = new Prestamos(
                libro,
                usuario,
                fchInicioPrestamo,
                fchFinPrestamo,
                fchEntregaPrestamo,
                estadoPrestamo);
        em.persist(prestamo);

        // Realiza otras operaciones CRUD aquí...
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
