package com.thunv.pojo;

import com.thunv.pojo.Item;
import com.thunv.pojo.OrderAgent;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-12T03:46:19")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Item> itemID;
    public static volatile SingularAttribute<OrderDetails, Integer> odID;
    public static volatile SingularAttribute<OrderDetails, Integer> quantity;
    public static volatile SingularAttribute<OrderDetails, OrderAgent> orderAgentID;

}