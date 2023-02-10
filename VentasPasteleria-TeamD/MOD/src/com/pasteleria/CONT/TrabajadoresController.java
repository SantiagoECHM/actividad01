package com.pasteleria.CONT;

import com.pasteleria.MOD.TrabajadorEntidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TrabajadoresController {
    private EntityManager em;

    public TrabajadoresController(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bdpasteleria");
        em = emf.createEntityManager();
    }

    public TrabajadoresController(EntityManager em){
        this.em = em;
    }

    public boolean Agregar(TrabajadorEntidad trabajador){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.persist(trabajador);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback(); //Esta cosa deshace los cambios en caso de error
            System.out.println(e);
            return false;
        }
    }

    public boolean Modificar(TrabajadorEntidad trabajador){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.merge(trabajador);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    public boolean Eliminar(TrabajadorEntidad trabajador){
        EntityTransaction tx = null;
        try{
            tx = em.getTransaction();
            tx.begin();
            em.remove(em.merge(trabajador));
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    //Los siguientes metodos listan todos los datos de forma diferente

    public List<TrabajadorEntidad> ListarTodos(){ //En realidad lista por nombre (default)
        try{
            List<TrabajadorEntidad> trabajadores = em.createNamedQuery("Trabajador.MostrarTodos").getResultList();
            return trabajadores;
        }catch (Exception e){
            System.out.println("Error al cargar los trabajadores de la base de datos");
            return null;
        }

    }

    public TrabajadorEntidad BuscarID(int id){
        try{
            TrabajadorEntidad trabajador = (TrabajadorEntidad) em.createNamedQuery("Trabajador.BuscarPorID")
                    .setParameter("id", id).getSingleResult();
            return trabajador;
        }catch (Exception e){
            return null;
        }
    }

    public TrabajadorEntidad BuscarPorNombre(String nombre){
        try{
            TrabajadorEntidad trabajador = (TrabajadorEntidad) em.createNamedQuery("Trabajador.BuscarPorNombre")
                    .setParameter("nombre", nombre).getSingleResult();
            return trabajador;
        }catch (Exception e){
            System.out.println("Error al traer al trabajador de la base de datos buscado por el nombre");
            return null;
        }
    }

    public List<TrabajadorEntidad> ListarPorPrimerApellido(){
        try{
            List<TrabajadorEntidad> trabajadores = em.createNamedQuery("Trabajador.MostrarPorApellidoUno").getResultList();
            return trabajadores;
        }catch (Exception e){
            System.out.println("Error al cargar los trabajadores de la base de datos");
            return null;
        }
    }

    public List<TrabajadorEntidad> ListarPorSegundoApellido(){
        try{
            List<TrabajadorEntidad> trabajadores = em.createNamedQuery("Trabajador.MostrarPorApellidoDos").getResultList();
            return trabajadores;
        }catch (Exception e){
            System.out.println("Error al cargar los trabajadores de la base de datos");
            return null;
        }
    }

    //Los metodos de abajo solo traen los campos necesarios para identificacion basica, utiles para llenar otros elementos
    public List<Integer> CrearListaID(){
        try{
            List<Integer> trabajadores = em.createNamedQuery("Trabajador.CrearListaID").getResultList();
            return trabajadores;
        }catch (Exception e){
            System.out.println("No se ha podido cargar la lista de ID de Trabajadores de la base de datos");
            return null;
        }
    }

    public List<TrabajadorEntidad> CrearListaNombres(){
        try{
            List<TrabajadorEntidad> trabajadores = em.createNamedQuery("Trabajador.CrearListaNombres").getResultList();
            return trabajadores;
        }catch (Exception e){
            System.out.println("No se ha podido cargar la lista de nombres de Trabajadores de la base de datos");
            return null;
        }
    }

    //Este metodo puede utilizarse para que en un ticket aparezca automaticamente el nombre enviando el ID del usuario que ha iniciado la sesión
    public TrabajadorEntidad FijarNombre(int id){
        try{
            TrabajadorEntidad trabajador = (TrabajadorEntidad) em.createNamedQuery("Trabajador.SeleccionarNombre").setParameter("id", id).getSingleResult();
            return trabajador;
        }catch (Exception e){
            System.out.println("Error al traer el nombre completo del trabajador de la base de datos");
            return null;
        }
    }

}
