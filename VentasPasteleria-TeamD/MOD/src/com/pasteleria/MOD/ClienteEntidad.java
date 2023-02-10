package com.pasteleria.MOD;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "bdpasteleriav4")
@NamedQueries({
        //Todos se muestra por nombre
        @NamedQuery(name="Clientes.MostrarTodos", query = "Select todo from ClienteEntidad todo order by todo.nombreCliente"),
        @NamedQuery(name="Clientes.MostrarPorPrimerApellido", query = "Select clientes from ClienteEntidad clientes order by clientes.primerApellido"),
        @NamedQuery(name="Clientes.MostrarPorSegundoApellido", query = "Select clientes from ClienteEntidad clientes order by clientes.segundoApellido"),
        @NamedQuery(name = "Clientes.BuscarPorID", query = "Select a from ClienteEntidad a where a.idCliente= :id"),
        @NamedQuery(name = "Clientes.BuscarPorNombre", query="Select a from ClienteEntidad a where a.nombreCliente like :nombre"),
        @NamedQuery(name ="Clientes.TraerNombres", query = "Select clientes.nombreCliente, clientes.primerApellido FROM ClienteEntidad as clientes order by clientes.nombreCliente"),
        @NamedQuery(name = "Clientes.CrearListaID", query = "Select clientes.idCliente from ClienteEntidad as clientes order by clientes.idCliente"),
})
public class ClienteEntidad {
    public ClienteEntidad() {
    }

    public ClienteEntidad(String nombreCliente, String primerApellido, String segundoApellido, String telefono) {
        this.nombreCliente = nombreCliente;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCliente", nullable = false)
    private int idCliente;
    @Basic
    @Column(name = "NombreCliente", nullable = false, length = 25)
    private String nombreCliente;
    @Basic
    @Column(name = "PrimerApellido", nullable = false, length = 25)
    private String primerApellido;
    @Basic
    @Column(name = "SegundoApellido", nullable = false, length = 25)
    private String segundoApellido;
    @Basic
    @Column(name = "Telefono", nullable = false, length = 15)
    private String telefono;
    @Basic
    @Column(name = "TelRecuperacion", nullable = true, length = 15)
    private String telRecuperacion;
    @Basic
    @Column(name = "Direccion_IDDireccion", nullable = false)
    private int direccionIdDireccion;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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

    public String getTelRecuperacion() {
        return telRecuperacion;
    }

    public void setTelRecuperacion(String telRecuperacion) {
        this.telRecuperacion = telRecuperacion;
    }

    public int getDireccionIdDireccion() {
        return direccionIdDireccion;
    }

    public void setDireccionIdDireccion(int direccionIdDireccion) {
        this.direccionIdDireccion = direccionIdDireccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntidad that = (ClienteEntidad) o;
        return idCliente == that.idCliente && direccionIdDireccion == that.direccionIdDireccion && Objects.equals(nombreCliente, that.nombreCliente) && Objects.equals(primerApellido, that.primerApellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(telefono, that.telefono) && Objects.equals(telRecuperacion, that.telRecuperacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombreCliente, primerApellido, segundoApellido, telefono, telRecuperacion, direccionIdDireccion);
    }
}
