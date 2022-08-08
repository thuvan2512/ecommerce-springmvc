package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.OrderAgent;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-09T01:32:16")
@StaticMetamodel(VoucherAgent.class)
public class VoucherAgent_ { 

    public static volatile SingularAttribute<VoucherAgent, Integer> times;
    public static volatile SingularAttribute<VoucherAgent, String> code;
    public static volatile SingularAttribute<VoucherAgent, Date> createdDate;
    public static volatile SingularAttribute<VoucherAgent, Integer> voucherID;
    public static volatile SingularAttribute<VoucherAgent, Date> expiredDate;
    public static volatile SingularAttribute<VoucherAgent, Agency> agencyID;
    public static volatile SetAttribute<VoucherAgent, OrderAgent> orderAgentSet;
    public static volatile SingularAttribute<VoucherAgent, Double> percentDiscount;

}