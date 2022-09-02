package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T17:27:43")
@StaticMetamodel(ReportAgent.class)
public class ReportAgent_ { 

    public static volatile SingularAttribute<ReportAgent, Integer> reportID;
    public static volatile SingularAttribute<ReportAgent, Agency> agencyID;
    public static volatile SingularAttribute<ReportAgent, String> title;
    public static volatile SingularAttribute<ReportAgent, Integer> settlementState;
    public static volatile SingularAttribute<ReportAgent, User> userID;
    public static volatile SingularAttribute<ReportAgent, String> content;
    public static volatile SingularAttribute<ReportAgent, User> sensorID;

}