/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ulima.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author w3109
 */
@Entity
@Table(name = "tbempleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll",
            query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByCodigo",
            query = "SELECT e FROM Empleado e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "Empleado.findByApellido",
            query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleado.findByNombre",
            query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByIngreso",
            query = "SELECT e FROM Empleado e WHERE e.ingreso = :ingreso")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "INGRESO")
    private Integer ingreso;
    @JoinColumn(name = "PARKING_ID", referencedColumnName = "ID")
    @ManyToOne
    private Parking parkingId;
    @JoinColumn(name = "DPTE_ID", referencedColumnName = "DPTO_ID")
    @ManyToOne
    private Departamento dpteId;

    public Empleado() {
    }

    public Empleado(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIngreso() {
        return ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    public Parking getParkingId() {
        return parkingId;
    }

    public void setParkingId(Parking parkingId) {
        this.parkingId = parkingId;
    }

    public Departamento getDpteId() {
        return dpteId;
    }

    public void setDpteId(Departamento dpteId) {
        this.dpteId = dpteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ulima.entidad.Empleado[ codigo=" + codigo + " ]";
    }
    
}
