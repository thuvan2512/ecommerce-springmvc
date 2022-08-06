/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByOdID", query = "SELECT o FROM OrderDetails o WHERE o.odID = :odID"),
    @NamedQuery(name = "OrderDetails.findByQuantity", query = "SELECT o FROM OrderDetails o WHERE o.quantity = :quantity")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odID")
    private Integer odID;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "itemID", referencedColumnName = "itemID")
    @ManyToOne
    private Item itemID;
    @JoinColumn(name = "orderAgentID", referencedColumnName = "oaID")
    @ManyToOne
    private OrderAgent orderAgentID;

    public OrderDetails() {
    }

    public OrderDetails(Integer odID) {
        this.odID = odID;
    }

    public Integer getOdID() {
        return odID;
    }

    public void setOdID(Integer odID) {
        this.odID = odID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItemID() {
        return itemID;
    }

    public void setItemID(Item itemID) {
        this.itemID = itemID;
    }

    public OrderAgent getOrderAgentID() {
        return orderAgentID;
    }

    public void setOrderAgentID(OrderAgent orderAgentID) {
        this.orderAgentID = orderAgentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odID != null ? odID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.odID == null && other.odID != null) || (this.odID != null && !this.odID.equals(other.odID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.OrderDetails[ odID=" + odID + " ]";
    }
    
}
