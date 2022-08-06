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
@Table(name = "order_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderState.findAll", query = "SELECT o FROM OrderState o"),
    @NamedQuery(name = "OrderState.findByOsID", query = "SELECT o FROM OrderState o WHERE o.osID = :osID"),
    @NamedQuery(name = "OrderState.findByName", query = "SELECT o FROM OrderState o WHERE o.name = :name")})
public class OrderState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "osID")
    private Integer osID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "orderState")
    private Set<Orders> ordersSet;

    public OrderState() {
    }

    public OrderState(Integer osID) {
        this.osID = osID;
    }

    public OrderState(Integer osID, String name) {
        this.osID = osID;
        this.name = name;
    }

    public Integer getOsID() {
        return osID;
    }

    public void setOsID(Integer osID) {
        this.osID = osID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osID != null ? osID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderState)) {
            return false;
        }
        OrderState other = (OrderState) object;
        if ((this.osID == null && other.osID != null) || (this.osID != null && !this.osID.equals(other.osID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.OrderState[ osID=" + osID + " ]";
    }
    
}
