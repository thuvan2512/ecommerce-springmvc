package com.thunv.pojo;

import com.thunv.pojo.CommentPost;
import com.thunv.pojo.PictureComment;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-12T03:46:19")
@StaticMetamodel(CommentPost.class)
public class CommentPost_ { 

    public static volatile SetAttribute<CommentPost, PictureComment> pictureCommentSet;
    public static volatile SingularAttribute<CommentPost, CommentPost> supComment;
    public static volatile SingularAttribute<CommentPost, Integer> commentID;
    public static volatile SetAttribute<CommentPost, CommentPost> commentPostSet;
    public static volatile SingularAttribute<CommentPost, SalePost> postID;
    public static volatile SingularAttribute<CommentPost, User> userID;
    public static volatile SingularAttribute<CommentPost, String> content;

}