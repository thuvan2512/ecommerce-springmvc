/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "picture_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PicturePost.findAll", query = "SELECT p FROM PicturePost p"),
    @NamedQuery(name = "PicturePost.findByPicID", query = "SELECT p FROM PicturePost p WHERE p.picID = :picID"),
    @NamedQuery(name = "PicturePost.findByImage", query = "SELECT p FROM PicturePost p WHERE p.image = :image"),
    @NamedQuery(name = "PicturePost.findByDescription", query = "SELECT p FROM PicturePost p WHERE p.description = :description")})
public class PicturePost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "picID")
    private Integer picID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "image")
    private String image;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "postID", referencedColumnName = "postID")
    @ManyToOne
    private SalePost postID;

    public PicturePost() {
    }

    public PicturePost(Integer picID) {
        this.picID = picID;
    }

    public PicturePost(Integer picID, String image) {
        this.picID = picID;
        this.image = image;
    }

    public Integer getPicID() {
        return picID;
    }

    public void setPicID(Integer picID) {
        this.picID = picID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (picID != null ? picID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PicturePost)) {
            return false;
        }
        PicturePost other = (PicturePost) object;
        if ((this.picID == null && other.picID != null) || (this.picID != null && !this.picID.equals(other.picID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.PicturePost[ picID=" + picID + " ]";
    }
    
}
