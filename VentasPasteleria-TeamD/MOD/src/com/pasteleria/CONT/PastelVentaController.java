package com.pasteleria.CONT;

import com.pasteleria.MOD.TieneEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

//En realidad este es el manejador de la entidad "Tiene" pero con un nombre mas descriptivo
public class PastelVentaController {
    private EntityManager em;

    public PastelVentaController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean Agregar(TieneEntidad pastelventa){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(pastelventa);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Modificar(TieneEntidad pastelventa){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(pastelventa);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Eliminar(TieneEntidad pastelventa){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(pastelventa));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public TieneEntidad BuscarVentaID(int id){
        try{
            TieneEntidad venta = (TieneEntidad) em.createNamedQuery("PastelVenta.BuscarVentaPorID")
                    .setParameter("id", id).getSingleResult();
            return venta;
        }catch (Exception e){
            return null;
        }
    }

    public TieneEntidad BuscarPastelID(int id){
        try{
            TieneEntidad pastel = (TieneEntidad) em.createNamedQuery("PastelVenta.BuscarPastelPorID")
                    .setParameter("id", id).getSingleResult();
            return pastel;
        }catch (Exception e){
            return null;
        }
    }

    public List<TieneEntidad> ListarVentas(){
        try{
            List<TieneEntidad> ventas = em.createNamedQuery("PastelVenta.ListarVentas").getResultList();
            return ventas;
        }catch (Exception e){
            System.out.println("Error al cargar las (ventas) de pasteles de la base de datos");
            return null;
        }
    }

    public List<TieneEntidad> ListarPasteles(){
        try{
            List<TieneEntidad> pasteles = em.createNamedQuery("PastelVenta.ListarPasteles").getResultList();
            return pasteles;
        }catch (Exception e){
            System.out.println("Error al cargar las ventas de (pasteles) de la base de datos");
            return null;
        }
    }

}
