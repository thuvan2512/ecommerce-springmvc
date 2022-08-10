package com.thunv.pojo;

import com.thunv.pojo.CommentPost;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-10T19:57:07")
@StaticMetamodel(PictureComment.class)
public class PictureComment_ { 

    public static volatile SingularAttribute<PictureComment, String> image;
    public static volatile SingularAttribute<PictureComment, String> description;
    public static volatile SingularAttribute<PictureComment, CommentPost> commentID;
    public static volatile SingularAttribute<PictureComment, Integer> picID;

}