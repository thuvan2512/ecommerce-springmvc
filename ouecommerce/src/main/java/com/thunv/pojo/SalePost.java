/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "sale_post")
@XmlRootElement
//@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQueries({
    @NamedQuery(name = "SalePost.findAll", query = "SELECT s FROM SalePost s"),
    @NamedQuery(name = "SalePost.findByPostID", query = "SELECT s FROM SalePost s WHERE s.postID = :postID"),
    @NamedQuery(name = "SalePost.findByAvatar", query = "SELECT s FROM SalePost s WHERE s.avatar = :avatar"),
    @NamedQuery(name = "SalePost.findByCreatedDate", query = "SELECT s FROM SalePost s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "SalePost.findByIsActive", query = "SELECT s FROM SalePost s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "SalePost.findByTitle", query = "SELECT s FROM SalePost s WHERE s.title = :title"),
    @NamedQuery(name = "SalePost.findByFinalPrice", query = "SELECT s FROM SalePost s WHERE s.finalPrice = :finalPrice"),
    @NamedQuery(name = "SalePost.findByInitialPrice", query = "SELECT s FROM SalePost s WHERE s.initialPrice = :initialPrice"),
    @NamedQuery(name = "SalePost.findByManufacturer", query = "SELECT s FROM SalePost s WHERE s.manufacturer = :manufacturer"),
    @NamedQuery(name = "SalePost.findByOrigin", query = "SELECT s FROM SalePost s WHERE s.origin = :origin"),
    @NamedQuery(name = "SalePost.findByBrand", query = "SELECT s FROM SalePost s WHERE s.brand = :brand"),
    @NamedQuery(name = "SalePost.findByDescription", query = "SELECT s FROM SalePost s WHERE s.description = :description")})
public class SalePost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "postID")
    private Integer postID;
    @Size(max = 200)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "isActive")
    private Integer isActive;
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "finalPrice")
    private Double finalPrice;
    @Column(name = "initialPrice")
    private Double initialPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "origin")
    private String origin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "postID")
    @JsonIgnore
    private Set<Classify> classifySet;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    @JsonIgnoreProperties({"responseAgentSet","manager","field","censorshipAgentSet","orderAgentSet","voucherAgentSet","reportAgentSet","followAgentSet","salePostSet"})
    private Agency agencyID;
    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID")
    @ManyToOne
//    @Basic(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"salePostSet"})
    private Category categoryID;
    @JoinColumn(name = "saleStatus", referencedColumnName = "stID")
    @ManyToOne
//    @Basic(fetch = FetchType.EAGER)
    @JsonIgnore
    private SaleStatus saleStatus;
    @OneToMany(mappedBy = "postID")
    @JsonIgnore
    private Set<Item> itemSet;
    @OneToMany(mappedBy = "postID")
    @JsonIgnore
    private Set<PicturePost> picturePostSet;
    @OneToMany(mappedBy = "postID")
    @JsonIgnore
    private Set<CommentPost> commentPostSet;
    @OneToMany(mappedBy = "postID")
    @JsonIgnore
    private Set<LikePost> likePostSet;
    @OneToMany(mappedBy = "postID")
    @JsonIgnore
    private Set<RatePost> ratePostSet;

    public SalePost() {
    }

    public SalePost(Integer postID) {
        this.postID = postID;
    }

    public SalePost(Integer postID, String manufacturer, String origin, String brand, String description) {
        this.postID = postID;
        this.manufacturer = manufacturer;
        this.origin = origin;
        this.brand = brand;
        this.description = description;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Set<Classify> getClassifySet() {
        return classifySet;
    }

    public void setClassifySet(Set<Classify> classifySet) {
        this.classifySet = classifySet;
    }

    public Agency getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Agency agencyID) {
        this.agencyID = agencyID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    @XmlTransient
    public Set<Item> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<Item> itemSet) {
        this.itemSet = itemSet;
    }

    @XmlTransient
    public Set<PicturePost> getPicturePostSet() {
        return picturePostSet;
    }

    public void setPicturePostSet(Set<PicturePost> picturePostSet) {
        this.picturePostSet = picturePostSet;
    }

    @XmlTransient
    public Set<CommentPost> getCommentPostSet() {
        return commentPostSet;
    }

    public void setCommentPostSet(Set<CommentPost> commentPostSet) {
        this.commentPostSet = commentPostSet;
    }

    @XmlTransient
    public Set<LikePost> getLikePostSet() {
        return likePostSet;
    }

    public void setLikePostSet(Set<LikePost> likePostSet) {
        this.likePostSet = likePostSet;
    }

    @XmlTransient
    public Set<RatePost> getRatePostSet() {
        return ratePostSet;
    }

    public void setRatePostSet(Set<RatePost> ratePostSet) {
        this.ratePostSet = ratePostSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postID != null ? postID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalePost)) {
            return false;
        }
        SalePost other = (SalePost) object;
        if ((this.postID == null && other.postID != null) || (this.postID != null && !this.postID.equals(other.postID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.SalePost[ postID=" + postID + " ]";
    }
    
}
