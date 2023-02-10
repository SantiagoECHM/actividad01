package com.pasteleria.CONT;


import com.pasteleria.MOD.PastelEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PastelesController {
    private EntityManager em;

    public PastelesController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public PastelesController(EntityManager em){
        this.em = em;
    }

    public boolean Agregar(PastelEntidad pastel){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(pastel);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Modificar(PastelEntidad pastel){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(pastel);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Eliminar(PastelEntidad pastel){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(pastel));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public List<PastelEntidad> ListarTodos(){
        try{
            List<PastelEntidad> pasteles = em.createNamedQuery("Pastel.MostrarTodos").getResultList();
            return pasteles;
        }catch (Exception e){
            System.out.println("Error al cargar los pasteles de la base de datos");
            return null;
        }
    }

    //Metodos que traen campos especificos, utiles para llenar cosas
    public List<Integer> CrearListaID(){
        try{
            List<Integer> pasteles = em.createNamedQuery("Pastel.CrearListaID").getResultList();
            return pasteles;
        }catch (Exception e){
            System.out.println("Error al cargar la lista de ID de los pasteles de la base de datos");
            return null;
        }
    }

    //Este metodo puede mostrar la cantidad que tiene el pastel actualmente
    public PastelEntidad MostrarCantidad(int id){
        try{
            PastelEntidad pastel = (PastelEntidad) em.createNamedQuery("Pastel.CrearListaCantidad").setParameter("id", id).getSingleResult();
            return pastel;
        }catch (Exception e){
            System.out.println("Error al mostrar la cantidad del pastel seleccionado");
            return null;
        }
    }

}
