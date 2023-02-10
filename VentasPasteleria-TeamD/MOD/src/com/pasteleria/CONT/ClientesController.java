package com.pasteleria.CONT;

import com.pasteleria.MOD.ClienteEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ClientesController {
    private EntityManager em;

    public ClientesController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public boolean AgregarCliente(ClienteEntidad cliente){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(cliente);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean ModificarCliente(ClienteEntidad cliente){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(cliente);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean EliminarCliente(ClienteEntidad cliente){
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(cliente);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public List<ClienteEntidad> ListarTodos(){
        try{
            List<ClienteEntidad> clientes = em.createNamedQuery("Clientes.MostrarTodos").getResultList();
            return clientes;
        } catch (Exception e){
            System.out.println("Error al cargar los clientes de la base de datos");
            return null;
        }
    }

    public ClienteEntidad BuscarID(int id){
        try{
            ClienteEntidad cliente = (ClienteEntidad) em.createNamedQuery("Clientes.BuscarPorID")
                    .setParameter("id", id).getSingleResult();
            return cliente;
        }catch (Exception e){
            System.out.println("Error al traer el cliente buscado por ID");
            return null;
        }
    }

    public ClienteEntidad BuscarPorNombre(String nombre){
        try{
            ClienteEntidad cliente = (ClienteEntidad) em.createNamedQuery("Clientes.BuscarPorNombre")
                    .setParameter("nombre", nombre).getSingleResult();
            return cliente;
        }catch (Exception e){
            System.out.println("Error al traer el cliente buscado por nombre");
            return null;
        }
    }

    public List<ClienteEntidad> ListarPorPrimerApellido(){
        try{
            List<ClienteEntidad> clientes = em.createNamedQuery("Clientes.MostrarPorPrimerApellido").getResultList();
            return clientes;
        } catch (Exception e){
            System.out.println("Error al cargar los clientes de la base de datos por primer apellido");
            return null;
        }
    }

    public List<ClienteEntidad> ListarPorSegundoApellido(){
        try{
            List<ClienteEntidad> clientes = em.createNamedQuery("Clientes.MostrarPorSegundoApellido").getResultList();
            return clientes;
        } catch (Exception e){
            System.out.println("Error al cargar los clientes de la base de datos por segundo apellido");
            return null;
        }
    }

    public List<ClienteEntidad> ListarPorNombreApellido(){
        try{
            List<ClienteEntidad> clientes = em.createNamedQuery("Clientes.TraerNombres").getResultList();
            return clientes;
        } catch (Exception e){
            System.out.println("Error al cargar los clientes y apellido de la base de datos");
            return null;
        }
    }

    public List<ClienteEntidad> CrearListaNombres(){
        try{
            List<ClienteEntidad> clientes = em.createNamedQuery("Clientes.TraerNombres").getResultList();
            return clientes;
        } catch (Exception e){
            System.out.println("Error al cargar la lista de nombres de la base de datos");
            return null;
        }
    }

    public List<ClienteEntidad> CrearListaID(){
        try{
            List<ClienteEntidad> clientes = em.createNamedQuery("Clientes.CrearListaID").getResultList();
            return clientes;
        } catch (Exception e){
            System.out.println("Error al cargar la lista de nombres de la base de datos");
            return null;
        }
    }

}
