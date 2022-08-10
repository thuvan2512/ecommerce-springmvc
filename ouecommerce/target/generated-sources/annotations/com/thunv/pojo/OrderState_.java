package com.thunv.pojo;

import com.thunv.pojo.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-10T19:57:07")
@StaticMetamodel(OrderState.class)
public class OrderState_ { 

    public static volatile SingularAttribute<OrderState, String> name;
    public static volatile SingularAttribute<OrderState, Integer> osID;
    public static volatile SetAttribute<OrderState, Orders> ordersSet;

}