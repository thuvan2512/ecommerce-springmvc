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
@Table(name = "auth_provider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthProvider.findAll", query = "SELECT a FROM AuthProvider a"),
    @NamedQuery(name = "AuthProvider.findByAuthID", query = "SELECT a FROM AuthProvider a WHERE a.authID = :authID"),
    @NamedQuery(name = "AuthProvider.findByName", query = "SELECT a FROM AuthProvider a WHERE a.name = :name")})
public class AuthProvider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authID")
    private Integer authID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "authProvider")
    private Set<User> userSet;

    public AuthProvider() {
    }

    public AuthProvider(Integer authID) {
        this.authID = authID;
    }

    public AuthProvider(Integer authID, String name) {
        this.authID = authID;
        this.name = name;
    }

    public Integer getAuthID() {
        return authID;
    }

    public void setAuthID(Integer authID) {
        this.authID = authID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authID != null ? authID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthProvider)) {
            return false;
        }
        AuthProvider other = (AuthProvider) object;
        if ((this.authID == null && other.authID != null) || (this.authID != null && !this.authID.equals(other.authID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.AuthProvider[ authID=" + authID + " ]";
    }
    
}
