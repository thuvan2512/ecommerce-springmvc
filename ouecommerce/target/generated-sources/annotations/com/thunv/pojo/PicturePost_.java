package com.thunv.pojo;

import com.thunv.pojo.SalePost;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T01:50:24")
@StaticMetamodel(PicturePost.class)
public class PicturePost_ { 

    public static volatile SingularAttribute<PicturePost, String> image;
    public static volatile SingularAttribute<PicturePost, String> description;
    public static volatile SingularAttribute<PicturePost, SalePost> postID;
    public static volatile SingularAttribute<PicturePost, Integer> picID;

}