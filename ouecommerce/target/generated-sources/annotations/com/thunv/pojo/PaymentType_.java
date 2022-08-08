package com.thunv.pojo;

import com.thunv.pojo.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-09T01:32:16")
@StaticMetamodel(PaymentType.class)
public class PaymentType_ { 

    public static volatile SingularAttribute<PaymentType, String> name;
    public static volatile SingularAttribute<PaymentType, Integer> ptID;
    public static volatile SetAttribute<PaymentType, Orders> ordersSet;

}