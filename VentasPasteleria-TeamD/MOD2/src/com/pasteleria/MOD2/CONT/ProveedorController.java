package com.pasteleria.MOD2.CONT;

import com.pasteleria.MOD2.MOD.EntidadProveedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProveedorController {
    private EntityManager em;

    public ProveedorController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean AgregarProveedor(EntidadProveedor proveedor){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(proveedor);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean ModificarProveedor(EntidadProveedor proveedor){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(proveedor);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarProveedor(EntidadProveedor proveedor){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(proveedor));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public List<EntidadProveedor> ListarTodos(){
        try{
            List<EntidadProveedor> proveedores = em.createNamedQuery("Proveedor.MostrarTodos").getResultList();
            return proveedores;
        }catch (Exception e){
            System.out.println("Error al cargar los proveedores [LSTD]");
            return null;
        }
    }

    public List<EntidadProveedor> CrearListaID(){
        try{
            List<EntidadProveedor> proveedores = em.createNamedQuery("Proveedor.CrearListaID").getResultList();
            return proveedores;
        }catch (Exception e){
            System.out.println("Error al crear la lista de ID de proveedor [CLID]");
            return null;
        }
    }

    public List<EntidadProveedor> CrearListaNombres(){
        try{
            List<EntidadProveedor> proveedores = em.createNamedQuery("Proveedor.CrearListaNombres").getResultList();
            return proveedores;
        }catch (Exception e){
            System.out.println("Error al cargar la lista de nombres de proveedores [CLN]");
            return null;
        }
    }

    public EntidadProveedor BuscarPorID(int id){
        try{
            EntidadProveedor proveedor = (EntidadProveedor) em.createNamedQuery("Proveedor.BuscarID").setParameter("id", id).getSingleResult();
            return proveedor;
        }catch (Exception e){
            System.out.println("Error al traer el proveedor buscado por ID [BID]");
            return null;
        }
    }
}
