package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-06T23:21:57")
@StaticMetamodel(CensorshipAgent.class)
public class CensorshipAgent_ { 

    public static volatile SingularAttribute<CensorshipAgent, User> censorID;
    public static volatile SingularAttribute<CensorshipAgent, Date> createdDate;
    public static volatile SingularAttribute<CensorshipAgent, Integer> censorshipID;
    public static volatile SingularAttribute<CensorshipAgent, Date> censoredDate;
    public static volatile SingularAttribute<CensorshipAgent, Agency> agencyID;
    public static volatile SingularAttribute<CensorshipAgent, User> userID;

}