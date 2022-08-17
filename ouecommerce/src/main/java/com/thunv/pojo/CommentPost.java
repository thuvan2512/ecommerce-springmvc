/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "comment_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentPost.findAll", query = "SELECT c FROM CommentPost c"),
    @NamedQuery(name = "CommentPost.findByCommentID", query = "SELECT c FROM CommentPost c WHERE c.commentID = :commentID"),
    @NamedQuery(name = "CommentPost.findByContent", query = "SELECT c FROM CommentPost c WHERE c.content = :content")})
public class CommentPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentID")
    private Integer commentID;
    @Size(max = 300,message = "{message.err.comment.size}")
    @Column(name = "content")
    private String content;
    @Column(name = "star_rate")
    private Integer starRate;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(mappedBy = "commentID")
    @JsonIgnoreProperties({"commentID",})
    private Set<PictureComment> pictureCommentSet;
    @OneToMany(mappedBy = "supComment",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<CommentPost> commentPostSet;
    @JoinColumn(name = "sup_comment", referencedColumnName = "commentID")
    @ManyToOne
    @JsonIgnore
    private CommentPost supComment;
    @JoinColumn(name = "postID", referencedColumnName = "postID")
    @ManyToOne
    @JsonIgnore
    private SalePost postID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    @JsonIgnore
    private User userID;

    public CommentPost() {
    }

    public CommentPost(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    @XmlTransient
    public Set<PictureComment> getPictureCommentSet() {
        return pictureCommentSet;
    }

    public void setPictureCommentSet(Set<PictureComment> pictureCommentSet) {
        this.pictureCommentSet = pictureCommentSet;
    }
    
    public Integer getStarRate() {
        return starRate;
    }

    public void setStarRate(Integer starRate) {
        this.starRate = starRate;
    }

    @XmlTransient
    public Set<CommentPost> getCommentPostSet() {
        return commentPostSet;
    }

    public void setCommentPostSet(Set<CommentPost> commentPostSet) {
        this.commentPostSet = commentPostSet;
    }

    public CommentPost getSupComment() {
        return supComment;
    }

    public void setSupComment(CommentPost supComment) {
        this.supComment = supComment;
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
        hash += (commentID != null ? commentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPost)) {
            return false;
        }
        CommentPost other = (CommentPost) object;
        if ((this.commentID == null && other.commentID != null) || (this.commentID != null && !this.commentID.equals(other.commentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.CommentPost[ commentID=" + commentID + " ]";
    }

}
