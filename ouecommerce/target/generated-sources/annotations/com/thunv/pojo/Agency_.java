package com.thunv.pojo;

import com.thunv.pojo.AgentField;
import com.thunv.pojo.CensorshipAgent;
import com.thunv.pojo.FollowAgent;
import com.thunv.pojo.OrderAgent;
import com.thunv.pojo.ReportAgent;
import com.thunv.pojo.ResponseAgent;
import com.thunv.pojo.SalePost;
import com.thunv.pojo.User;
import com.thunv.pojo.VoucherAgent;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-06T23:21:57")
@StaticMetamodel(Agency.class)
public class Agency_ { 

    public static volatile SetAttribute<Agency, FollowAgent> followAgentSet;
    public static volatile SetAttribute<Agency, CensorshipAgent> censorshipAgentSet;
    public static volatile SetAttribute<Agency, VoucherAgent> voucherAgentSet;
    public static volatile SingularAttribute<Agency, String> address;
    public static volatile SingularAttribute<Agency, User> manager;
    public static volatile SingularAttribute<Agency, String> hotline;
    public static volatile SetAttribute<Agency, ReportAgent> reportAgentSet;
    public static volatile SingularAttribute<Agency, Integer> agencyID;
    public static volatile SingularAttribute<Agency, String> avatar;
    public static volatile SetAttribute<Agency, OrderAgent> orderAgentSet;
    public static volatile SingularAttribute<Agency, Integer> isActive;
    public static volatile SingularAttribute<Agency, Integer> isCensored;
    public static volatile SetAttribute<Agency, ResponseAgent> responseAgentSet;
    public static volatile SingularAttribute<Agency, Date> createdDate;
    public static volatile SingularAttribute<Agency, AgentField> field;
    public static volatile SingularAttribute<Agency, String> coverImage;
    public static volatile SetAttribute<Agency, SalePost> salePostSet;
    public static volatile SingularAttribute<Agency, String> name;

}