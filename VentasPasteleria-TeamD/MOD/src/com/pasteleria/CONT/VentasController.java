package com.pasteleria.CONT;

import com.pasteleria.MOD.VentaEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class VentasController {
    private EntityManager em;

    public VentasController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean Agregar(VentaEntidad venta){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(venta);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Modificar(VentaEntidad venta){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(venta);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Eliminar(VentaEntidad venta){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(venta));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public VentaEntidad BuscarPorID(int id){
        try{
            VentaEntidad venta = (VentaEntidad) em.createNamedQuery("Ventas.BuscarPorID").setParameter("id", id).getSingleResult();
            return venta;
        }catch (Exception e){
            return null;
        }
    }

    public List<VentaEntidad> ListarTodasPorFecha(){
        try{
            List<VentaEntidad> ventas = em.createNamedQuery("Ventas.ListarPorFecha").getResultList();
            return ventas;
        }catch (Exception e){
            System.out.println("Error al traer las ventas por fecha de la base de datos");
            return null;
        }
    }

    public List<VentaEntidad> ListarTodasPorID(){
        try{
            List<VentaEntidad> ventas = em.createNamedQuery("Ventas.ListarPorID").getResultList();
            return ventas;
        }catch (Exception e){
            System.out.println("Error al traer las ventas ordenadas por ID de la base de datos");
            return null;
        }
    }

    public List<Integer> CrearListaID(){
        try{
            List<Integer> ventas = em.createNamedQuery("Ventas.CrearListaID").getResultList();
            return ventas;
        }catch (Exception e){
            System.out.println("Error al traer la lista de ID de ventas desde la base de datos");
            return null;
        }
    }
}
