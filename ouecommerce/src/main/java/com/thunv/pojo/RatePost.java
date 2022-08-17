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
@Table(name = "rate_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RatePost.findAll", query = "SELECT r FROM RatePost r"),
    @NamedQuery(name = "RatePost.findByRateID", query = "SELECT r FROM RatePost r WHERE r.rateID = :rateID"),
    @NamedQuery(name = "RatePost.findByStar", query = "SELECT r FROM RatePost r WHERE r.star = :star")})
public class RatePost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rateID")
    private Integer rateID;
    @Column(name = "star")
    private Integer star;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "postID", referencedColumnName = "postID")
    @ManyToOne
    private SalePost postID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;

    public RatePost() {
    }

    public RatePost(Integer rateID) {
        this.rateID = rateID;
    }

    public Integer getRateID() {
        return rateID;
    }

    public void setRateID(Integer rateID) {
        this.rateID = rateID;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public SalePost getPostID() {
        return postID;
    }

    public void setPostID(SalePost postID) {
        this.postID = postID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateID != null ? rateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatePost)) {
            return false;
        }
        RatePost other = (RatePost) object;
        if ((this.rateID == null && other.rateID != null) || (this.rateID != null && !this.rateID.equals(other.rateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.RatePost[ rateID=" + rateID + " ]";
    }
    
}
