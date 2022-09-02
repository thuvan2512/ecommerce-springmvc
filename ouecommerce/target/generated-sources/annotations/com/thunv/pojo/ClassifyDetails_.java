package com.thunv.pojo;

import com.thunv.pojo.Classify;
import com.thunv.pojo.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T17:27:43")
@StaticMetamodel(ClassifyDetails.class)
public class ClassifyDetails_ { 

    public static volatile SingularAttribute<ClassifyDetails, Integer> cdID;
    public static volatile SingularAttribute<ClassifyDetails, Classify> classifyID;
    public static volatile SingularAttribute<ClassifyDetails, String> value;
    public static volatile SetAttribute<ClassifyDetails, Item> itemSet;

}