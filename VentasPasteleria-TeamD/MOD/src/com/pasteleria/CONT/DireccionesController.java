package com.pasteleria.CONT;

import com.pasteleria.MOD.DireccionEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class DireccionesController {
    private EntityManager em;

    public DireccionesController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean AgregarDireccion(DireccionEntidad direccion){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(direccion);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean ModificarDireccion(DireccionEntidad direccion){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(direccion);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarDireccion(DireccionEntidad direccion){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(direccion);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public List<DireccionEntidad> ListarTodas(){
        try{
            List<DireccionEntidad> direcciones = em.createNamedQuery("Direcciones.ListarTodas").getResultList();
            return direcciones;
        }catch (Exception e){
            System.out.println("Error al cargar las direcciones de la base de datos");
            return null;
        }
    }

    public List<DireccionEntidad> ListarPorCiudad(){
        try{
            List<DireccionEntidad> direcciones = em.createNamedQuery("Direcciones.ListarPorCiudad").getResultList();
            return direcciones;
        } catch (Exception e){
            System.out.println("Error al cargar las direcciones de la base de datos");
            return null;
        }
    }

    public List<DireccionEntidad> ListarPorColonia(){
        try{
            List<DireccionEntidad> direcciones = em.createNamedQuery("Direcciones.ListarPorColonia").getResultList();
            return direcciones;
        }catch (Exception e){
            System.out.println("Error al cargar las direcciones de la base de datos");
            return null;
        }
    }

    public List<DireccionEntidad> ListarPorCalle(){
        try{
            List<DireccionEntidad> direcciones = em.createNamedQuery("Direcciones.ListarPorCalle").getResultList();
            return direcciones;
        }catch (Exception e){
            System.out.println("Error al cargar las direcciones de la base de datos");
            return null;
        }
    }

    public List<Integer> CrearListaID(){
        try{
            List<Integer> direcciones = em.createNamedQuery("Direcciones.CrearListaID").getResultList();
            return direcciones;
        }catch (Exception e){
            System.out.println("Error al crear la lista de ID de direcciones de la base de datos");
            return null;
        }
    }

    public List<DireccionEntidad> CrearListaCiudades(){
        try{
            List<DireccionEntidad> direcciones = em.createNamedQuery("Direcciones.CrearListaCiudades").getResultList();
            return direcciones;
        }catch (Exception e){
            System.out.println("Error al crear la lista de Ciudades de direcciones de la base de datos");
            return null;
        }
    }

    public List<DireccionEntidad> CrearListaColonias(){
        try{
            List<DireccionEntidad> direcciones = em.createNamedQuery("Direcciones.CrearListaColonias").getResultList();
            return direcciones;
        }catch (Exception e){
            System.out.println("Error al crear la lista de Colonias de direcciones de la base de datos");
            return null;
        }
    }

}
