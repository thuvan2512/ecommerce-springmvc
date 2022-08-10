package com.thunv.pojo;

import com.thunv.pojo.ClassifyDetails;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.SalePost;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-10T19:57:07")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Double> unitPrice;
    public static volatile SetAttribute<Item, ClassifyDetails> classifyDetailsSet;
    public static volatile SetAttribute<Item, OrderDetails> orderDetailsSet;
    public static volatile SingularAttribute<Item, Integer> itemID;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, Integer> isClassified;
    public static volatile SingularAttribute<Item, String> avatar;
    public static volatile SingularAttribute<Item, SalePost> postID;
    public static volatile SingularAttribute<Item, Integer> isActive;
    public static volatile SingularAttribute<Item, Integer> inventory;

}