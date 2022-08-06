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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "classify_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClassifyDetails.findAll", query = "SELECT c FROM ClassifyDetails c"),
    @NamedQuery(name = "ClassifyDetails.findByCdID", query = "SELECT c FROM ClassifyDetails c WHERE c.cdID = :cdID"),
    @NamedQuery(name = "ClassifyDetails.findByValue", query = "SELECT c FROM ClassifyDetails c WHERE c.value = :value")})
public class ClassifyDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cdID")
    private Integer cdID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "value")
    private String value;
    @JoinTable(name = "classify_details_item", joinColumns = {
        @JoinColumn(name = "classifyDetailsID", referencedColumnName = "cdID")}, inverseJoinColumns = {
        @JoinColumn(name = "itemID", referencedColumnName = "itemID")})
    @ManyToMany
    private Set<Item> itemSet;
    @JoinColumn(name = "classifyID", referencedColumnName = "classifyID")
    @ManyToOne
    private Classify classifyID;

    public ClassifyDetails() {
    }

    public ClassifyDetails(Integer cdID) {
        this.cdID = cdID;
    }

    public ClassifyDetails(Integer cdID, String value) {
        this.cdID = cdID;
        this.value = value;
    }

    public Integer getCdID() {
        return cdID;
    }

    public void setCdID(Integer cdID) {
        this.cdID = cdID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlTransient
    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }

    public Classify getClassifyID() {
        return classifyID;
    }

    public void setClassifyID(Classify classifyID) {
        this.classifyID = classifyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdID != null ? cdID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassifyDetails)) {
            return false;
        }
        ClassifyDetails other = (ClassifyDetails) object;
        if ((this.cdID == null && other.cdID != null) || (this.cdID != null && !this.cdID.equals(other.cdID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.ClassifyDetails[ cdID=" + cdID + " ]";
    }
    
}
