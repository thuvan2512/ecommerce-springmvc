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
@Table(name = "follow_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FollowAgent.findAll", query = "SELECT f FROM FollowAgent f"),
    @NamedQuery(name = "FollowAgent.findByFaID", query = "SELECT f FROM FollowAgent f WHERE f.faID = :faID"),
    @NamedQuery(name = "FollowAgent.findByIsFollow", query = "SELECT f FROM FollowAgent f WHERE f.isFollow = :isFollow"),
    @NamedQuery(name = "FollowAgent.findByCreatedDate", query = "SELECT f FROM FollowAgent f WHERE f.createdDate = :createdDate"),
    @NamedQuery(name = "FollowAgent.findByUpdatedDate", query = "SELECT f FROM FollowAgent f WHERE f.updatedDate = :updatedDate")})
public class FollowAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "faID")
    private Integer faID;
    @Column(name = "isFollow")
    private Integer isFollow;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    private Agency agencyID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;

    public FollowAgent() {
    }

    public FollowAgent(Integer faID) {
        this.faID = faID;
    }

    public Integer getFaID() {
        return faID;
    }

    public void setFaID(Integer faID) {
        this.faID = faID;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faID != null ? faID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowAgent)) {
            return false;
        }
        FollowAgent other = (FollowAgent) object;
        if ((this.faID == null && other.faID != null) || (this.faID != null && !this.faID.equals(other.faID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.FollowAgent[ faID=" + faID + " ]";
    }
    
}
