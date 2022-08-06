/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "voucher_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherAgent.findAll", query = "SELECT v FROM VoucherAgent v"),
    @NamedQuery(name = "VoucherAgent.findByVoucherID", query = "SELECT v FROM VoucherAgent v WHERE v.voucherID = :voucherID"),
    @NamedQuery(name = "VoucherAgent.findByCode", query = "SELECT v FROM VoucherAgent v WHERE v.code = :code"),
    @NamedQuery(name = "VoucherAgent.findByPercentDiscount", query = "SELECT v FROM VoucherAgent v WHERE v.percentDiscount = :percentDiscount"),
    @NamedQuery(name = "VoucherAgent.findByCreatedDate", query = "SELECT v FROM VoucherAgent v WHERE v.createdDate = :createdDate"),
    @NamedQuery(name = "VoucherAgent.findByExpiredDate", query = "SELECT v FROM VoucherAgent v WHERE v.expiredDate = :expiredDate"),
    @NamedQuery(name = "VoucherAgent.findByTimes", query = "SELECT v FROM VoucherAgent v WHERE v.times = :times")})
public class VoucherAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "voucherID")
    private Integer voucherID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentDiscount")
    private Double percentDiscount;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "expiredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Column(name = "times")
    private Integer times;
    @OneToMany(mappedBy = "voucherID")
    private Set<OrderAgent> orderAgentSet;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    private Agency agencyID;

    public VoucherAgent() {
    }

    public VoucherAgent(Integer voucherID) {
        this.voucherID = voucherID;
    }

    public VoucherAgent(Integer voucherID, String code) {
        this.voucherID = voucherID;
        this.code = code;
    }

    public Integer getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Integer voucherID) {
        this.voucherID = voucherID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @XmlTransient
    public Set<OrderAgent> getOrderAgentSet() {
        return orderAgentSet;
    }

    public void setOrderAgentSet(Set<OrderAgent> orderAgentSet) {
        this.orderAgentSet = orderAgentSet;
    }

    public Agency getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Agency agencyID) {
        this.agencyID = agencyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voucherID != null ? voucherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoucherAgent)) {
            return false;
        }
        VoucherAgent other = (VoucherAgent) object;
        if ((this.voucherID == null && other.voucherID != null) || (this.voucherID != null && !this.voucherID.equals(other.voucherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.VoucherAgent[ voucherID=" + voucherID + " ]";
    }
    
}
