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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "picture_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PictureComment.findAll", query = "SELECT p FROM PictureComment p"),
    @NamedQuery(name = "PictureComment.findByPicID", query = "SELECT p FROM PictureComment p WHERE p.picID = :picID"),
    @NamedQuery(name = "PictureComment.findByImage", query = "SELECT p FROM PictureComment p WHERE p.image = :image"),
    @NamedQuery(name = "PictureComment.findByDescription", query = "SELECT p FROM PictureComment p WHERE p.description = :description")})
public class PictureComment implements Serializable {

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
    @JoinColumn(name = "commentID", referencedColumnName = "commentID")
    @ManyToOne
    private CommentPost commentID;

    public PictureComment() {
    }

    public PictureComment(Integer picID) {
        this.picID = picID;
    }

    public PictureComment(Integer picID, String image) {
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

    public CommentPost getCommentID() {
        return commentID;
    }

    public void setCommentID(CommentPost commentID) {
        this.commentID = commentID;
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
        if (!(object instanceof PictureComment)) {
            return false;
        }
        PictureComment other = (PictureComment) object;
        if ((this.picID == null && other.picID != null) || (this.picID != null && !this.picID.equals(other.picID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.PictureComment[ picID=" + picID + " ]";
    }
    
}
