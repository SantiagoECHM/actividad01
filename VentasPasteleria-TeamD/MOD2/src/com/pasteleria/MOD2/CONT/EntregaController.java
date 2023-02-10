package com.pasteleria.MOD2.CONT;

import com.pasteleria.MOD2.MOD.EntidadEntrega;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EntregaController {
    private EntityManager em;

    public EntregaController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean AgregarEntrega(EntidadEntrega entrega){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(entrega);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean ModificarEntrega(EntidadEntrega entrega){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(entrega);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarEntrega(EntidadEntrega entrega){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(entrega));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public List<EntidadEntrega> ListarEntregas(){
        try{
            List<EntidadEntrega> entregas = em.createNamedQuery("Entrega.MostrarTodas").getResultList();
            return entregas;
        }catch (Exception e){
            System.out.println("Error al cargar las entregas");
            return null;
        }
    }

    public EntidadEntrega BuscarEntrega(int proveedor, int mercancia){
        try{
            EntidadEntrega entrega = (EntidadEntrega) em.createNamedQuery("Entrega.SeleccionarUna")
                    .setParameter("proveedor", proveedor)
                    .setParameter("mercancia", mercancia)
                    .getSingleResult();
            return entrega;
        }catch (Exception e){
            System.out.println("Error al encontrar la entrega especificada");
            return null;
        }
    }

    public EntidadEntrega BuscarProveedorDeEntrega(int proveedor){
        try{
            EntidadEntrega entrega = (EntidadEntrega) em.createNamedQuery("Entrega.SeleccionarProveedor")
                    .setParameter("proveedor", proveedor)
                    .getSingleResult();
            return entrega;
        }catch (Exception e){
            System.out.println("Error al encontrar el proveedor de la entrega buscada");
            return null;
        }
    }

    public EntidadEntrega BuscarMercanciaDeEntrega(int mercancia){
        try{
            EntidadEntrega entrega = (EntidadEntrega) em.createNamedQuery("Entrega.SeleccionarMercancia")
                    .setParameter("mercancia", mercancia)
                    .getSingleResult();
            return entrega;
        }catch (Exception e){
            System.out.println("Error al encontrar la mercancia de la entrega buscada");
            return null;
        }
    }
}
