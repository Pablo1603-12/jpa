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
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Operaciones CRUD  Accesos
            //crearAcceso(em);
            //leerAcceso(em);
            // Operaciones CRUD Usuario
            //crearUsuario(em);
            //leerUsuario(em);
            actualizarUsuario(em);
            //eliminarUsuario(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

//ACCESOS
    public static void crearAcceso(EntityManager em) {

        Accesos acceso = new Accesos("Usu", "Acceso Usuario Biblioteca");
        em.persist(acceso);

    }

    public static void leerAcceso(EntityManager em) {

        TypedQuery<Accesos> query = em.createQuery("SELECT u FROM Accesos u", Accesos.class
        );
        List<Accesos> accesos = query.getResultList();

        if (accesos.isEmpty()) {
            System.out.println("No se encontraron usuarios.");
        } else {
            System.out.println("Usuarios encontrados:");
            for (Accesos acceso : accesos) {
                System.out.println("id: " + acceso.getId_acceso());
                System.out.println("Cod_acceso: " + acceso.getCodigo_acceso());
                System.out.println("Nombre: " + acceso.getDescripcion_acceso());

                System.out.println("-------------------------------------------------");
                System.out.println("");
            }
        }

        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();

        }

    }

    public static void actualicarAcceso(EntityManager em) {

    }

    public static void eliminarAcceso(EntityManager em) {
    }

    //USUARIOS
    public static void crearUsuario(EntityManager em) {
        leerAcceso(em);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del acceso: ");
        int id = scanner.nextInt();

        TypedQuery<Accesos> query = em.createQuery("SELECT u FROM Accesos u", Accesos.class);
        List<Accesos> accesos = query.getResultList();

        Accesos acceso = accesos.get(id);

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

    }

    public static void leerUsuario(EntityManager em) {

        TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u", Usuarios.class
        );
        List<Usuarios> usuarios = query.getResultList();

        if (usuarios.isEmpty()) {
            System.out.println("No se encontraron usuarios.");
        } else {
            System.out.println("Usuarios encontrados:");
            for (Usuarios usuario : usuarios) {
                System.out.println("ID: " + usuario.getIdUsuario());
                System.out.println("Nombre: " + usuario.getNombreUsuario());
                System.out.println("Apellido: " + usuario.getApellidosUsuario());
                System.out.println("DNI: " + usuario.getDniUsuario());
                System.out.println("Tlf: " + usuario.getTlfUsuario());
                System.out.println("Email: " + usuario.getEmailUsuario());
                System.out.println("Acceso: " + usuario.getAcceso().getDescripcion_acceso());
                System.out.println("-------------------------------------------------");
                System.out.println("");
            }
        }

        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();

        }

    }

    public static void actualizarUsuario(EntityManager em) {

        System.out.println("USUARIOS DISPONIBLES:");
        leerUsuario(em);
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        // Pedir al usuario que seleccione un ID de usuario para actualizar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario que desea actualizar: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        Usuarios usuario = em.find(Usuarios.class, userId);

        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println("ID: " + usuario.getIdUsuario());
            System.out.println("Nombre actual: " + usuario.getNombreUsuario());
            System.out.println("Apellido actual: " + usuario.getApellidosUsuario());
            System.out.println("DNI actual: " + usuario.getDniUsuario());
            System.out.println("Tlf actual: " + usuario.getTlfUsuario());
            System.out.println("Email actual: " + usuario.getEmailUsuario());
            System.out.println("Acceso actual" + usuario.getAcceso().getDescripcion_acceso());

//            System.out.print("Nuevo nombre: ");
//            String nuevoNombre = scanner.nextLine();
//
//            if (!nuevoNombre.isEmpty()) {
//                usuario.setNombreUsuario(nuevoNombre);
//            }
//
//            System.out.print("Nuevos apellidos: ");
//            String nuevosApellidos = scanner.nextLine();
//            scanner.nextLine();
//            if (!nuevosApellidos.isEmpty()) {
//                usuario.setApellidosUsuario(nuevosApellidos);
//            }
//
//            System.out.print("Nuevo DNI: ");
//            String nuevoDni = scanner.nextLine();
//            if (!nuevoDni.isEmpty()) {
//                usuario.setDniUsuario(nuevoDni);
//            }
//            System.out.print("Nuevo teléfono: ");
//            String nuevoTlf = scanner.nextLine();
//            if (!nuevoTlf.isEmpty()) {
//                usuario.setTlfUsuario(nuevoTlf);
//            }
//            System.out.print("Nuevo email: ");
//            String nuevoEmail = scanner.nextLine();
//            if (!nuevoEmail.isEmpty()) {
//                usuario.setEmailUsuario(nuevoEmail);
//            }
            leerAcceso(em);

            System.out.print("Ingrese el ID del nuevo acceso: ");
            int id = scanner.nextInt();

            TypedQuery<Accesos> query = em.createQuery("SELECT u FROM Accesos u", Accesos.class);
            List<Accesos> accesos = query.getResultList();

            if (id >= 0 && id < accesos.size()) {
                Accesos acceso = accesos.get(id);
                usuario.setAcceso(acceso);
            } else {
                System.out.println("El ID ingresado no es válido. Asegúrate de ingresar un número entre 0 y " + (accesos.size() - 1));
            }

            em.getTransaction().commit();
            System.out.println("Usuario actualizado con éxito");
        } else {
            System.out.println("Usuario no encontrado");
        }

    }

    public static void eliminarUsuario(EntityManager em) {
        leerUsuario(em);

        try {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID del usuario que desea eliminar: ");
            int id = scanner.nextInt();

            Usuarios usuario = em.find(Usuarios.class,
                    id);
            if (usuario != null) {
                // Eliminar el usuario de la base de datos
                em.remove(usuario);
                // Comprobar si la transacción está activa antes de confirmarla

                em.getTransaction().commit();

                System.out.println("Usuario eliminado con éxito");
            } else {
                System.out.println("Usuario no encontrado");
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }

}
