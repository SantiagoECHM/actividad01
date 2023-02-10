package com.pasteleria.MOD2.CONT;

import com.pasteleria.MOD2.MOD.EntidadMercancia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MercanciaController {
    private EntityManager em;

    public MercanciaController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean AgregarMercancia(EntidadMercancia mercancia){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(mercancia);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean ModificarMercancia(EntidadMercancia mercancia){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(mercancia);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarMercancia(EntidadMercancia mercancia){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(mercancia));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public List<EntidadMercancia> ListarTodas(){
        try{
            List<EntidadMercancia> mercancias = em.createNamedQuery("Mercancia.ListarTodas").getResultList();
            return mercancias;
        }catch (Exception e){
            System.out.println("Error al listar todas las mercancias [LSTDS]");
            return null;
        }
    }

    public List<EntidadMercancia> CrearListaID(){
        try{
            List<EntidadMercancia> mercancias = em.createNamedQuery("Mercancia.CrearListaID").getResultList();
            return mercancias;
        }catch (Exception e){
            System.out.println("Error al crear la lista de ID de mercancia [CLID]");
            return null;
        }
    }

    public List<EntidadMercancia> CrearListaNombres(){
        try{
            List<EntidadMercancia> mercancias = em.createNamedQuery("Mercancia.CrearListaNombres").getResultList();
            return mercancias;
        }catch (Exception e){
            System.out.println("Error al crear la lista de nombres de mercancia [CLNS]");
            return null;
        }
    }

    public EntidadMercancia BuscarID(int id){
        try{
            EntidadMercancia mercancia = (EntidadMercancia) em.createNamedQuery("Mercancia.BuscarID").getSingleResult();
            return mercancia;
        }catch (Exception e){
            System.out.println("Error al buscar la mercancia por ID [BMID]");
            return null;
        }
    }
}
