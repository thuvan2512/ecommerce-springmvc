package com.thunv.pojo;

import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-06T23:21:57")
@StaticMetamodel(RatePost.class)
public class RatePost_ { 

    public static volatile SingularAttribute<RatePost, Integer> star;
    public static volatile SingularAttribute<RatePost, SalePost> postID;
    public static volatile SingularAttribute<RatePost, User> userID;
    public static volatile SingularAttribute<RatePost, Integer> rateID;

}