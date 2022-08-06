package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.Category;
import com.thunv.pojo.Classify;
import com.thunv.pojo.CommentPost;
import com.thunv.pojo.Item;
import com.thunv.pojo.LikePost;
import com.thunv.pojo.PicturePost;
import com.thunv.pojo.RatePost;
import com.thunv.pojo.SaleStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-06T23:21:57")
@StaticMetamodel(SalePost.class)
public class SalePost_ { 

    public static volatile SetAttribute<SalePost, PicturePost> picturePostSet;
    public static volatile SingularAttribute<SalePost, Double> initialPrice;
    public static volatile SingularAttribute<SalePost, String> origin;
    public static volatile SingularAttribute<SalePost, Double> finalPrice;
    public static volatile SingularAttribute<SalePost, String> description;
    public static volatile SetAttribute<SalePost, RatePost> ratePostSet;
    public static volatile SingularAttribute<SalePost, Agency> agencyID;
    public static volatile SingularAttribute<SalePost, Integer> postID;
    public static volatile SingularAttribute<SalePost, String> avatar;
    public static volatile SingularAttribute<SalePost, SaleStatus> saleStatus;
    public static volatile SetAttribute<SalePost, CommentPost> commentPostSet;
    public static volatile SingularAttribute<SalePost, Integer> isActive;
    public static volatile SingularAttribute<SalePost, String> title;
    public static volatile SetAttribute<SalePost, Item> itemSet;
    public static volatile SingularAttribute<SalePost, String> manufacturer;
    public static volatile SetAttribute<SalePost, Classify> classifySet;
    public static volatile SingularAttribute<SalePost, Date> createdDate;
    public static volatile SetAttribute<SalePost, LikePost> likePostSet;
    public static volatile SingularAttribute<SalePost, String> brand;
    public static volatile SingularAttribute<SalePost, Category> categoryID;

}