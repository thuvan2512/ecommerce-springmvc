package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T01:50:24")
@StaticMetamodel(ResponseAgent.class)
public class ResponseAgent_ { 

    public static volatile SingularAttribute<ResponseAgent, Integer> star;
    public static volatile SingularAttribute<ResponseAgent, Agency> agencyID;
    public static volatile SingularAttribute<ResponseAgent, Integer> resID;
    public static volatile SingularAttribute<ResponseAgent, User> userID;
    public static volatile SingularAttribute<ResponseAgent, String> content;

}