/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemID", query = "SELECT i FROM Item i WHERE i.itemID = :itemID"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByAvatar", query = "SELECT i FROM Item i WHERE i.avatar = :avatar"),
    @NamedQuery(name = "Item.findByIsActive", query = "SELECT i FROM Item i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "Item.findByUnitPrice", query = "SELECT i FROM Item i WHERE i.unitPrice = :unitPrice"),
    @NamedQuery(name = "Item.findByInventory", query = "SELECT i FROM Item i WHERE i.inventory = :inventory"),
    @NamedQuery(name = "Item.findByIsClassified", query = "SELECT i FROM Item i WHERE i.isClassified = :isClassified")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemID")
    private Integer itemID;
    @Size(min = 1,max = 50,message = "{message.err.itemName.size}")
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "isActive")
    private Integer isActive;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unitPrice")
    @Min(value = 1,message = "{message.err.price.min}")
    @NotNull(message = "{message.err.notNull}")
    private Double unitPrice;
    @Min(value = 0,message = "{message.err.inventory.min}")
    @Column(name = "inventory")
    @NotNull(message = "{message.err.notNull}")
    private Integer inventory;
    @Column(name = "isClassified")
    private Integer isClassified;
    @ManyToMany(mappedBy = "itemSet")
    @JsonIgnore
    private Set<ClassifyDetails> classifyDetailsSet;
    @OneToMany(mappedBy = "itemID")
    @JsonIgnore
    private Set<OrderDetails> orderDetailsSet;
    @JoinColumn(name = "postID", referencedColumnName = "postID")
    @ManyToOne
    @JsonIgnore
    private SalePost postID;
    @Size(min = 1, max = 50,message = "{message.err.itemDescription.size}")
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item() {
    }

    public Item(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getIsClassified() {
        return isClassified;
    }

    public void setIsClassified(Integer isClassified) {
        this.isClassified = isClassified;
    }
    @XmlTransient
    public Set<ClassifyDetails> getClassifyDetailsSet() {
        return classifyDetailsSet;
    }

    public void setClassifyDetailsSet(Set<ClassifyDetails> classifyDetailsSet) {
        this.classifyDetailsSet = classifyDetailsSet;
    }

    @XmlTransient
    public Set<OrderDetails> getOrderDetailsSet() {
        return orderDetailsSet;
    }

    public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
        this.orderDetailsSet = orderDetailsSet;
    }

    public SalePost getPostID() {
        return postID;
    }

    public void setPostID(SalePost postID) {
        this.postID = postID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.Item[ itemID=" + itemID + " ]";
    }
    
}
