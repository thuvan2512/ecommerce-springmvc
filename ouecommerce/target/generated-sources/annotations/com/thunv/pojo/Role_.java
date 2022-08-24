package com.thunv.pojo;

import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T01:50:24")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> roleID;
    public static volatile SingularAttribute<Role, String> name;
    public static volatile SetAttribute<Role, User> userSet;

}