package com.thunv.pojo;

import com.thunv.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-08T00:40:23")
@StaticMetamodel(Gender.class)
public class Gender_ { 

    public static volatile SingularAttribute<Gender, Integer> genderID;
    public static volatile SingularAttribute<Gender, String> name;
    public static volatile SetAttribute<Gender, User> userSet;

}