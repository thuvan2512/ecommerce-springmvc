package com.thunv.pojo;

import com.thunv.pojo.SalePost;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-12T03:46:19")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SetAttribute<Category, SalePost> salePostSet;
    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, String> avatar;
    public static volatile SingularAttribute<Category, Integer> categoryID;

}