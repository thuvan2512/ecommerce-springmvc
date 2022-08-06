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
@Table(name = "agent_field")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentField.findAll", query = "SELECT a FROM AgentField a"),
    @NamedQuery(name = "AgentField.findByAfID", query = "SELECT a FROM AgentField a WHERE a.afID = :afID"),
    @NamedQuery(name = "AgentField.findByName", query = "SELECT a FROM AgentField a WHERE a.name = :name")})
public class AgentField implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "afID")
    private Integer afID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "field")
    private Set<Agency> agencySet;

    public AgentField() {
    }

    public AgentField(Integer afID) {
        this.afID = afID;
    }

    public AgentField(Integer afID, String name) {
        this.afID = afID;
        this.name = name;
    }

    public Integer getAfID() {
        return afID;
    }

    public void setAfID(Integer afID) {
        this.afID = afID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Agency> getAgencySet() {
        return agencySet;
    }

    public void setAgencySet(Set<Agency> agencySet) {
        this.agencySet = agencySet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afID != null ? afID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentField)) {
            return false;
        }
        AgentField other = (AgentField) object;
        if ((this.afID == null && other.afID != null) || (this.afID != null && !this.afID.equals(other.afID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.AgentField[ afID=" + afID + " ]";
    }
    
}
