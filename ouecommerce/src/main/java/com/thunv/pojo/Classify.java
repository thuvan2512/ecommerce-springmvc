/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "classify")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classify.findAll", query = "SELECT c FROM Classify c"),
    @NamedQuery(name = "Classify.findByClassifyID", query = "SELECT c FROM Classify c WHERE c.classifyID = :classifyID"),
    @NamedQuery(name = "Classify.findByName", query = "SELECT c FROM Classify c WHERE c.name = :name")})
public class Classify implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "classifyID")
    private Integer classifyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "postID", referencedColumnName = "postID")
    @ManyToOne
    @JsonIgnore
    private SalePost postID;
    @JsonIgnoreProperties({"itemSet","classifyID"})
    @OneToMany(mappedBy = "classifyID",fetch = FetchType.EAGER)
    private Set<ClassifyDetails> classifyDetailsSet;

    public Classify() {
    }

    public Classify(Integer classifyID) {
        this.classifyID = classifyID;
    }

    public Classify(Integer classifyID, String name) {
        this.classifyID = classifyID;
        this.name = name;
    }

    public Integer getClassifyID() {
        return classifyID;
    }

    public void setClassifyID(Integer classifyID) {
        this.classifyID = classifyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalePost getPostID() {
        return postID;
    }

    public void setPostID(SalePost postID) {
        this.postID = postID;
    }

    @XmlTransient
    public Set<ClassifyDetails> getClassifyDetailsSet() {
        return classifyDetailsSet;
    }

    public void setClassifyDetailsSet(Set<ClassifyDetails> classifyDetailsSet) {
        this.classifyDetailsSet = classifyDetailsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classifyID != null ? classifyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classify)) {
            return false;
        }
        Classify other = (Classify) object;
        if ((this.classifyID == null && other.classifyID != null) || (this.classifyID != null && !this.classifyID.equals(other.classifyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.Classify[ classifyID=" + classifyID + " ]";
    }
    
}
