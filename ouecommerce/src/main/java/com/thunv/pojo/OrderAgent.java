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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "order_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderAgent.findAll", query = "SELECT o FROM OrderAgent o"),
    @NamedQuery(name = "OrderAgent.findByOaID", query = "SELECT o FROM OrderAgent o WHERE o.oaID = :oaID"),
    @NamedQuery(name = "OrderAgent.findByTotalPrice", query = "SELECT o FROM OrderAgent o WHERE o.totalPrice = :totalPrice"),
    @NamedQuery(name = "OrderAgent.findByPromoPrice", query = "SELECT o FROM OrderAgent o WHERE o.promoPrice = :promoPrice"),
    @NamedQuery(name = "OrderAgent.findByOrderAgentcol", query = "SELECT o FROM OrderAgent o WHERE o.orderAgentcol = :orderAgentcol")})
public class OrderAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "oaID")
    private Integer oaID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPrice")
    private Double totalPrice;
    @Column(name = "promoPrice")
    private Double promoPrice;
    @Size(max = 45)
    @Column(name = "order_agentcol")
    private String orderAgentcol;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    private Agency agencyID;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne
    private Orders orderID;
    @JoinColumn(name = "voucherID", referencedColumnName = "voucherID")
    @ManyToOne
    private VoucherAgent voucherID;

    public OrderAgent() {
    }

    public OrderAgent(Integer oaID) {
        this.oaID = oaID;
    }

    public Integer getOaID() {
        return oaID;
    }

    public void setOaID(Integer oaID) {
        this.oaID = oaID;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public String getOrderAgentcol() {
        return orderAgentcol;
    }

    public void setOrderAgentcol(String orderAgentcol) {
        this.orderAgentcol = orderAgentcol;
    }

    public Agency getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Agency agencyID) {
        this.agencyID = agencyID;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

    public VoucherAgent getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(VoucherAgent voucherID) {
        this.voucherID = voucherID;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oaID != null ? oaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderAgent)) {
            return false;
        }
        OrderAgent other = (OrderAgent) object;
        if ((this.oaID == null && other.oaID != null) || (this.oaID != null && !this.oaID.equals(other.oaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.OrderAgent[ oaID=" + oaID + " ]";
    }
    
}
