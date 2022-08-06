/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "censorship_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CensorshipAgent.findAll", query = "SELECT c FROM CensorshipAgent c"),
    @NamedQuery(name = "CensorshipAgent.findByCensorshipID", query = "SELECT c FROM CensorshipAgent c WHERE c.censorshipID = :censorshipID"),
    @NamedQuery(name = "CensorshipAgent.findByCreatedDate", query = "SELECT c FROM CensorshipAgent c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CensorshipAgent.findByCensoredDate", query = "SELECT c FROM CensorshipAgent c WHERE c.censoredDate = :censoredDate")})
public class CensorshipAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "censorshipID")
    private Integer censorshipID;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "censoredDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date censoredDate;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    private Agency agencyID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;
    @JoinColumn(name = "censorID", referencedColumnName = "userID")
    @ManyToOne
    private User censorID;

    public CensorshipAgent() {
    }

    public CensorshipAgent(Integer censorshipID) {
        this.censorshipID = censorshipID;
    }

    public Integer getCensorshipID() {
        return censorshipID;
    }

    public void setCensorshipID(Integer censorshipID) {
        this.censorshipID = censorshipID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCensoredDate() {
        return censoredDate;
    }

    public void setCensoredDate(Date censoredDate) {
        this.censoredDate = censoredDate;
    }

    public Agency getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Agency agencyID) {
        this.agencyID = agencyID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public User getCensorID() {
        return censorID;
    }

    public void setCensorID(User censorID) {
        this.censorID = censorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (censorshipID != null ? censorshipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CensorshipAgent)) {
            return false;
        }
        CensorshipAgent other = (CensorshipAgent) object;
        if ((this.censorshipID == null && other.censorshipID != null) || (this.censorshipID != null && !this.censorshipID.equals(other.censorshipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.CensorshipAgent[ censorshipID=" + censorshipID + " ]";
    }
    
}
