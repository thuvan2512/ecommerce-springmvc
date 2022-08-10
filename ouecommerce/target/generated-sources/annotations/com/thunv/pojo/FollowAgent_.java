package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-10T19:57:07")
@StaticMetamodel(FollowAgent.class)
public class FollowAgent_ { 

    public static volatile SingularAttribute<FollowAgent, Integer> isFollow;
    public static volatile SingularAttribute<FollowAgent, Date> createdDate;
    public static volatile SingularAttribute<FollowAgent, Integer> faID;
    public static volatile SingularAttribute<FollowAgent, Agency> agencyID;
    public static volatile SingularAttribute<FollowAgent, Date> updatedDate;
    public static volatile SingularAttribute<FollowAgent, User> userID;

}