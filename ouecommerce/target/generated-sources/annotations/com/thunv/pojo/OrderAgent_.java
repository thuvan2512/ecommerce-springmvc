package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.Orders;
import com.thunv.pojo.VoucherAgent;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T17:27:43")
@StaticMetamodel(OrderAgent.class)
public class OrderAgent_ { 

    public static volatile SingularAttribute<OrderAgent, Double> promoPrice;
    public static volatile SingularAttribute<OrderAgent, Double> totalPrice;
    public static volatile SingularAttribute<OrderAgent, Orders> orderID;
    public static volatile SingularAttribute<OrderAgent, VoucherAgent> voucherID;
    public static volatile SingularAttribute<OrderAgent, String> orderAgentcol;
    public static volatile SingularAttribute<OrderAgent, Agency> agencyID;
    public static volatile SingularAttribute<OrderAgent, Integer> oaID;

}