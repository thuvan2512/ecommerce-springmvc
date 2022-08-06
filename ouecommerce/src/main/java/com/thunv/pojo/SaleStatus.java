/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "sale_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleStatus.findAll", query = "SELECT s FROM SaleStatus s"),
    @NamedQuery(name = "SaleStatus.findByStID", query = "SELECT s FROM SaleStatus s WHERE s.stID = :stID"),
    @NamedQuery(name = "SaleStatus.findByName", query = "SELECT s FROM SaleStatus s WHERE s.name = :name")})
public class SaleStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stID")
    private Integer stID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "saleStatus")
    private Set<SalePost> salePostSet;

    public SaleStatus() {
    }

    public SaleStatus(Integer stID) {
        this.stID = stID;
    }

    public SaleStatus(Integer stID, String name) {
        this.stID = stID;
        this.name = name;
    }

    public Integer getStID() {
        return stID;
    }

    public void setStID(Integer stID) {
        this.stID = stID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<SalePost> getSalePostSet() {
        return salePostSet;
    }

    public void setSalePostSet(Set<SalePost> salePostSet) {
        this.salePostSet = salePostSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stID != null ? stID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleStatus)) {
            return false;
        }
        SaleStatus other = (SaleStatus) object;
        if ((this.stID == null && other.stID != null) || (this.stID != null && !this.stID.equals(other.stID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.SaleStatus[ stID=" + stID + " ]";
    }
    
}
