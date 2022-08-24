package com.thunv.pojo;

import com.thunv.pojo.ClassifyDetails;
import com.thunv.pojo.SalePost;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-25T01:50:24")
@StaticMetamodel(Classify.class)
public class Classify_ { 

    public static volatile SetAttribute<Classify, ClassifyDetails> classifyDetailsSet;
    public static volatile SingularAttribute<Classify, Integer> classifyID;
    public static volatile SingularAttribute<Classify, String> name;
    public static volatile SingularAttribute<Classify, SalePost> postID;

}