package com.pasteleria.MOD;
//El controlador de esta entidad se llama "PastelVentaController"
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tiene", schema = "bdpasteleriav4")
@NamedQueries({
        @NamedQuery(name = "PastelVenta.ListarVentas", query = "Select a from TieneEntidad a order by a.ventaIdVenta"),
        @NamedQuery(name = "PastelVenta.BuscarVentaPorID", query="Select v from TieneEntidad v where v.ventaIdVenta = :id"),
        @NamedQuery(name = "PastelVenta.BuscarPastelPorID", query="Select p from TieneEntidad p where p.pastelIdPastel = :id"),
        @NamedQuery(name = "PastelVenta.ListarPasteles", query = "Select a from TieneEntidad a order by a.pastelIdPastel"),
})

@IdClass(TieneEntidadPK.class)
public class TieneEntidad {
    public TieneEntidad() {
    }

    public TieneEntidad(String estado, Integer cantidad, int pastelId, int ventaIdVenta) {
        this.estado = estado;
        this.cantidad = cantidad;
        this.pastelIdPastel=pastelId;
        this.ventaIdVenta = ventaIdVenta;
    }

    @Basic
    @Column(name = "Estado", nullable = false, length = 20)
    private String estado;

    @Basic
    @Column(name = "Cantidad", nullable = false, length = 20)
    private Integer cantidad;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Pastel_IDPastel", nullable = false )
    private int pastelIdPastel;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Venta_IDVenta", nullable = false)
    private int ventaIdVenta;

//    @ManyToOne
//    @JoinColumn(name = "Pastel_IDPastel", referencedColumnName = "IDPastel", nullable = false)
//    private PastelEntidad pastel;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getPastelIdPastel() {
        return pastelIdPastel;
    }

    public void setPastelIdPastel(int pastelIdPastel) {
        this.pastelIdPastel = pastelIdPastel;
    }

    public int getVentaIdVenta() {
        return ventaIdVenta;
    }

    public void setVentaIdVenta(int ventaIdVenta) {
        this.ventaIdVenta = ventaIdVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TieneEntidad that = (TieneEntidad) o;
        return ventaIdVenta == that.ventaIdVenta && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estado, ventaIdVenta);
    }

//    public PastelEntidad getPastelByPastelIdPastel() {
//        return pastel;
//    }

//    public void setPastelByPastelIdPastel(PastelEntidad pastelByPastelIdPastel) {
//        this.pastel = pastelByPastelIdPastel;
//    }
}
