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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "response_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponseAgent.findAll", query = "SELECT r FROM ResponseAgent r"),
    @NamedQuery(name = "ResponseAgent.findByResID", query = "SELECT r FROM ResponseAgent r WHERE r.resID = :resID"),
    @NamedQuery(name = "ResponseAgent.findByStar", query = "SELECT r FROM ResponseAgent r WHERE r.star = :star"),
    @NamedQuery(name = "ResponseAgent.findByContent", query = "SELECT r FROM ResponseAgent r WHERE r.content = :content")})
public class ResponseAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "resID")
    private Integer resID;
    @Column(name = "star")
    private Integer star;
    @Size(max = 200)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    private Agency agencyID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;

    public ResponseAgent() {
    }

    public ResponseAgent(Integer resID) {
        this.resID = resID;
    }

    public Integer getResID() {
        return resID;
    }

    public void setResID(Integer resID) {
        this.resID = resID;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        hash += (resID != null ? resID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponseAgent)) {
            return false;
        }
        ResponseAgent other = (ResponseAgent) object;
        if ((this.resID == null && other.resID != null) || (this.resID != null && !this.resID.equals(other.resID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.ResponseAgent[ resID=" + resID + " ]";
    }
    
}
