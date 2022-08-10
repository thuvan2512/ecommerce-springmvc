package com.thunv.pojo;

import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-10T19:57:07")
@StaticMetamodel(AuthProvider.class)
public class AuthProvider_ { 

    public static volatile SingularAttribute<AuthProvider, String> name;
    public static volatile SetAttribute<AuthProvider, User> userSet;
    public static volatile SingularAttribute<AuthProvider, Integer> authID;

}