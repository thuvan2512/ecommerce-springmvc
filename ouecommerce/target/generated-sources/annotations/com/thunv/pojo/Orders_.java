package com.thunv.pojo;

import com.thunv.pojo.OrderAgent;
import com.thunv.pojo.OrderDetails;
import com.thunv.pojo.OrderState;
import com.thunv.pojo.PaymentType;
import com.thunv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T01:50:24")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SetAttribute<Orders, OrderDetails> orderDetailsSet;
    public static volatile SingularAttribute<Orders, Date> createdDate;
    public static volatile SingularAttribute<Orders, Integer> orderID;
    public static volatile SingularAttribute<Orders, Double> totalPrice;
    public static volatile SetAttribute<Orders, OrderAgent> orderAgentSet;
    public static volatile SingularAttribute<Orders, Integer> paymentState;
    public static volatile SingularAttribute<Orders, User> userID;
    public static volatile SingularAttribute<Orders, OrderState> orderState;
    public static volatile SingularAttribute<Orders, PaymentType> paymentType;

}