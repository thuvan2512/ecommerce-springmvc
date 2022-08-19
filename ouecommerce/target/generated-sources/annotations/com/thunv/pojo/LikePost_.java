package com.thunv.pojo;

import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-20T01:23:16")
@StaticMetamodel(LikePost.class)
public class LikePost_ { 

    public static volatile SingularAttribute<LikePost, Integer> likeID;
    public static volatile SingularAttribute<LikePost, Integer> state;
    public static volatile SingularAttribute<LikePost, SalePost> postID;
    public static volatile SingularAttribute<LikePost, User> userID;

}