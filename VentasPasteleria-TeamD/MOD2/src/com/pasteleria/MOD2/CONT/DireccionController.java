package com.pasteleria.MOD2.CONT;

import com.pasteleria.MOD2.MOD.EntidadDireccion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DireccionController {
    private EntityManager em;

    public DireccionController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean AgregarDireccion(EntidadDireccion direccion){
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

    public boolean ModificarDireccion(EntidadDireccion direccion){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(direccion);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarDireccion(EntidadDireccion direccion){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(direccion));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    //public List<EntidadDireccion> ListarTodasDirecciones
}
