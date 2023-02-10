package com.pasteleria.MOD2.MOD;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Proveedor.MostrarTodos", query = "select proveedor from EntidadProveedor proveedor order by proveedor.nomEmpresa"),
        @NamedQuery(name = "Proveedor.CrearListaID", query = "select proveedor.idProveedor from EntidadProveedor as proveedor order by proveedor.idProveedor"),
        @NamedQuery(name = "Proveedor.BuscarID", query ="select proveedor from EntidadProveedor proveedor where proveedor.idProveedor = :id"),
        @NamedQuery(name = "Proveedor.CrearListaNombres", query = "select proveedor.nomEmpresa from EntidadProveedor as proveedor order by proveedor.nomEmpresa"),
})
@Table(name = "proveedor", schema = "bdproveedores")
public class EntidadProveedor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDProveedor", nullable = false)
    private int idProveedor;
    @Basic
    @Column(name = "NomEmpresa", nullable = false, length = 20)
    private String nomEmpresa;
    @Basic
    @Column(name = "Correo", nullable = false, length = 30)
    private String correo;
    @Basic
    @Column(name = "CodigoPostal", nullable = false)
    private int codigoPostal;
    @Basic
    @Column(name = "Telefono", nullable = false, length = 20)
    private String telefono;
    @Basic
    @Column(name = "Direccion_IDDireccion", nullable = false)
    private int direccionIdDireccion;
    @OneToMany(mappedBy = "proveedorByProveedorIdProveedor")
    private Collection<EntidadEntrega> entregasByIdProveedor;
    @ManyToOne
    @JoinColumn(name = "Direccion_IDDireccion", referencedColumnName = "IDDIreccion", nullable = false)
    private EntidadDireccion direccionByDireccionIdDireccion;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        EntidadProveedor that = (EntidadProveedor) o;
        return idProveedor == that.idProveedor && codigoPostal == that.codigoPostal && direccionIdDireccion == that.direccionIdDireccion && Objects.equals(nomEmpresa, that.nomEmpresa) && Objects.equals(correo, that.correo) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProveedor, nomEmpresa, correo, codigoPostal, telefono, direccionIdDireccion);
    }

    public Collection<EntidadEntrega> getEntregasByIdProveedor() {
        return entregasByIdProveedor;
    }

    public void setEntregasByIdProveedor(Collection<EntidadEntrega> entregasByIdProveedor) {
        this.entregasByIdProveedor = entregasByIdProveedor;
    }

    public EntidadDireccion getDireccionByDireccionIdDireccion() {
        return direccionByDireccionIdDireccion;
    }

    public void setDireccionByDireccionIdDireccion(EntidadDireccion direccionByDireccionIdDireccion) {
        this.direccionByDireccionIdDireccion = direccionByDireccionIdDireccion;
    }
}
