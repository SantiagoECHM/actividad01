package com.pasteleria.MOD;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "venta", schema = "bdpasteleriav4")
@NamedQueries({
        @NamedQuery(name = "Ventas.BuscarPorID", query = "Select venta from VentaEntidad venta where venta.idVenta = :id"),
        @NamedQuery(name = "Ventas.ListarPorFecha", query = "select ventas from VentaEntidad ventas order by ventas.fechaVenta"),
        @NamedQuery(name = "Ventas.ListarPorID", query = "select ventas from VentaEntidad ventas order by ventas.idVenta"),
        @NamedQuery(name = "Ventas.CrearListaID", query = "select ventas.idVenta from VentaEntidad as ventas order by ventas.idVenta")
})
public class VentaEntidad {
    public VentaEntidad() {
    }

    public VentaEntidad(String tipo, Time horaVenta, Date fechaVenta, int total, TrabajadorEntidad trabajadorEntidad) {
        this.tipo = tipo;
        this.horaEntrega = horaVenta;
        this.fechaEntrega = fechaVenta;
        this.horaVenta = horaVenta;
        this.fechaVenta = fechaVenta;
        this.anticipo = 0;
        this.total = total;
        this.entregado = "true";
        this.trabajadorByTrabajadorIdTrabajador=trabajadorEntidad;
    }

    public VentaEntidad(String tipo, Time horaEntrega, Date fechaEntrega, int anticipo, int total, String entregado, TrabajadorEntidad trabajadorByTrabajadorIdTrabajador, ClienteEntidad clienteByClienteIdCliente) {
        this.tipo = tipo;
        this.horaEntrega = horaEntrega;
        this.fechaEntrega = fechaEntrega;
        this.anticipo = anticipo;
        this.total = total;
        this.entregado = entregado;
        this.trabajadorByTrabajadorIdTrabajador = trabajadorByTrabajadorIdTrabajador;
        this.clienteByClienteIdCliente = clienteByClienteIdCliente;
    }

    public VentaEntidad(String tipo, Time horaEntrega, Date fechaEntrega, String entregado, TrabajadorEntidad trabajadorByTrabajadorIdTrabajador) {
        this.tipo = tipo;
        this.horaEntrega = horaEntrega;
        this.fechaEntrega = fechaEntrega;
        this.entregado = entregado;
        this.trabajadorByTrabajadorIdTrabajador = trabajadorByTrabajadorIdTrabajador;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVenta", nullable = false)
    private int idVenta;
    @Basic
    @Column(name = "Tipo", nullable = false, length = 25)
    private String tipo;
    @Basic
    @Column(name = "HoraEntrega", nullable = true)
    private Time horaEntrega;
    @Basic
    @Column(name = "FechaEntrega", nullable = true)
    private Date fechaEntrega;
    @Basic
    @Column(name = "HoraVenta", nullable = true)
    private Time horaVenta;
    @Basic
    @Column(name = "FechaVenta", nullable = true)
    private Date fechaVenta;
    @Basic
    @Column(name = "Anticipo", nullable = false, precision = 0)
    private int anticipo;
    @Basic
    @Column(name = "Total", nullable = false, precision = 0)
    private int total;
    @Basic
    @Column(name = "Entregado", nullable = false, length = 5)
    private String entregado;
//    @Basic
//    @Column(name = "Trabajador_IDTrabajador", nullable = false)
//    private int trabajadorIdTrabajador;
//    @Basic
//    @Column(name = "Cliente_IDCliente", nullable = true)
//    private int clienteIdCliente;

    @OneToMany(mappedBy = "ventaIdVenta")
    private Collection<TieneEntidad> tienesByIdVenta;

    @ManyToOne
    @JoinColumn(name = "Trabajador_IDTrabajador", referencedColumnName = "IDTrabajador", nullable = true)
    private TrabajadorEntidad trabajadorByTrabajadorIdTrabajador;

    @ManyToOne
    @JoinColumn(name = "Cliente_IDCliente", referencedColumnName = "IDCliente", nullable = true)
    private ClienteEntidad clienteByClienteIdCliente;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Time horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(int anticipo) {
        this.anticipo = anticipo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

//    public int getTrabajadorIdTrabajador() {
//        return trabajadorIdTrabajador;
//    }
//
//    public void setTrabajadorIdTrabajador(int trabajadorIdTrabajador) {
//        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
//    }
//
//    public int getClienteIdCliente() {
//        return clienteIdCliente;
//    }
//
//    public void setClienteIdCliente(int clienteIdCliente) {
//        this.clienteIdCliente = clienteIdCliente;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaEntidad that = (VentaEntidad) o;
        return idVenta == that.idVenta && anticipo == that.anticipo && total == that.total && Objects.equals(tipo, that.tipo) && Objects.equals(horaEntrega, that.horaEntrega) && Objects.equals(fechaEntrega, that.fechaEntrega) && Objects.equals(horaVenta, that.horaVenta) && Objects.equals(fechaVenta, that.fechaVenta) && Objects.equals(entregado, that.entregado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, tipo, horaEntrega, fechaEntrega, horaVenta, fechaVenta, anticipo, total, entregado);
    }

    public Collection<TieneEntidad> getTienesByIdVenta() {
        return tienesByIdVenta;
    }

    public void setTienesByIdVenta(Collection<TieneEntidad> tienesByIdVenta) {
        this.tienesByIdVenta = tienesByIdVenta;
    }

    public TrabajadorEntidad getTrabajadorByTrabajadorIdTrabajador() {
        return trabajadorByTrabajadorIdTrabajador;
    }

    public void setTrabajadorByTrabajadorIdTrabajador(TrabajadorEntidad trabajadorByTrabajadorIdTrabajador) {
        this.trabajadorByTrabajadorIdTrabajador = trabajadorByTrabajadorIdTrabajador;
    }

    public ClienteEntidad getClienteByClienteIdCliente() {
        return clienteByClienteIdCliente;
    }

    public void setClienteByClienteIdCliente(ClienteEntidad clienteByClienteIdCliente) {
        this.clienteByClienteIdCliente = clienteByClienteIdCliente;
    }
}
