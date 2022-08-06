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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "like_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikePost.findAll", query = "SELECT l FROM LikePost l"),
    @NamedQuery(name = "LikePost.findByLikeID", query = "SELECT l FROM LikePost l WHERE l.likeID = :likeID"),
    @NamedQuery(name = "LikePost.findByState", query = "SELECT l FROM LikePost l WHERE l.state = :state")})
public class LikePost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "likeID")
    private Integer likeID;
    @Column(name = "state")
    private Integer state;
    @JoinColumn(name = "postID", referencedColumnName = "postID")
    @ManyToOne
    private SalePost postID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;

    public LikePost() {
    }

    public LikePost(Integer likeID) {
        this.likeID = likeID;
    }

    public Integer getLikeID() {
        return likeID;
    }

    public void setLikeID(Integer likeID) {
        this.likeID = likeID;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (likeID != null ? likeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikePost)) {
            return false;
        }
        LikePost other = (LikePost) object;
        if ((this.likeID == null && other.likeID != null) || (this.likeID != null && !this.likeID.equals(other.likeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.LikePost[ likeID=" + likeID + " ]";
    }
    
}
