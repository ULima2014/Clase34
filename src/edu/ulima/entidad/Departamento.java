/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ulima.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author w3109
 */
@Entity
@Table(name = "tbdepartamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByDptoId", query = "SELECT d FROM Departamento d WHERE d.dptoId = :dptoId"),
    @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DPTO_ID")
    private Integer dptoId;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "dpteId")
    private Collection<Empleado> empleadoCollection;

    public Departamento() {
    }

    public Departamento(Integer dptoId) {
        this.dptoId = dptoId;
    }

    public Integer getDptoId() {
        return dptoId;
    }

    public void setDptoId(Integer dptoId) {
        this.dptoId = dptoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dptoId != null ? dptoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.dptoId == null && other.dptoId != null) || (this.dptoId != null && !this.dptoId.equals(other.dptoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ulima.entidad.Departamento[ dptoId=" + dptoId + " ]";
    }
    
}
