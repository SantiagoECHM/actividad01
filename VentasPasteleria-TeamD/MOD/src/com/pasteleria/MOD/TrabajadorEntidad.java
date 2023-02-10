package com.pasteleria.MOD;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trabajador", schema = "bdpasteleriav4")

@NamedQueries({
        //Las siguientes querys a pesar de hacer de forma variada, traen todos los datos
        @NamedQuery(name = "Trabajador.MostrarTodos", query = "Select todo from TrabajadorEntidad todo order by todo.nombre"),
        @NamedQuery(name = "Trabajador.BuscarPorID", query = "Select trab from TrabajadorEntidad trab where trab.idTrabajador= :id"),
        @NamedQuery(name = "Trabajador.BuscarPorNombre", query="Select a from TrabajadorEntidad a where a.nombre like :nombre"),
        @NamedQuery(name = "Trabajador.MostrarPorApellidoUno", query = "Select trabajadores from TrabajadorEntidad trabajadores order by trabajadores.primerApellido"),
        @NamedQuery(name = "Trabajador.MostrarPorApellidoDos", query = "Select trabajadores from TrabajadorEntidad trabajadores order by trabajadores.segundoApellido"),
        //Estas querys traen solo datos relevantes para relaciones
        @NamedQuery(name = "Trabajador.CrearListaID", query = "select trabajadores.id from TrabajadorEntidad as trabajadores order by trabajadores.id"),
        @NamedQuery(name = "Trabajador.CrearListaNombres", query = "Select trabajadores.nombre, trabajadores.primerApellido, trabajadores.segundoApellido FROM TrabajadorEntidad as trabajadores order by trabajadores.nombre"),
        //Esta consulta es especial para uso de sesion, ir al metodo a ver mas info
        @NamedQuery(name = "Trabajador.SeleccionarNombre", query = "Select trabajador.nombre, trabajador.primerApellido, trabajador.segundoApellido FROM TrabajadorEntidad as trabajador WHERE trabajador.id = :id"),
})


public class TrabajadorEntidad {
    public TrabajadorEntidad(TrabajadorEntidad trabajadorEntidad) {
        this.nombre = trabajadorEntidad.getNombre();
        this.primerApellido = trabajadorEntidad.getPrimerApellido();
        this.segundoApellido = trabajadorEntidad.getSegundoApellido();
        this.telefono = trabajadorEntidad.getTelefono();
        this.pass = trabajadorEntidad.getPass();
        this.tipo = trabajadorEntidad.getTipo();
    }

    public TrabajadorEntidad(int idTrabajador, String nombre, String primerApellido, String segundoApellido, String telefono, String pass, String tipo) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.pass = pass;
        this.tipo = tipo;
    }

    public TrabajadorEntidad(String nombre, String primerApellido, String segundoApellido, String telefono, String pass, String tipo) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.pass = pass;
        this.tipo = tipo;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDTrabajador", nullable = false)
    private int idTrabajador;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 25)
    private String nombre;
    @Basic
    @Column(name = "PrimerApellido", nullable = false, length = 25)
    private String primerApellido;
    @Basic
    @Column(name = "SegundoApellido", nullable = true, length = 25)
    private String segundoApellido;
    @Basic
    @Column(name = "Telefono", nullable = false, length = 15)
    private String telefono;
    @Basic
    @Column(name = "Pass", nullable = false, length = 30)
    private String pass;
    @Basic
    @Column(name = "Tipo", nullable = false, length = 15)
    private String tipo;

    public TrabajadorEntidad() {

    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrabajadorEntidad that = (TrabajadorEntidad) o;
        return idTrabajador == that.idTrabajador && Objects.equals(nombre, that.nombre) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(telefono, that.telefono) && Objects.equals(pass, that.pass) && Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrabajador, nombre, primerApellido, segundoApellido, telefono, pass, tipo);
    }
}
