package com.thunv.pojo;

import com.thunv.pojo.Agency;
import com.thunv.pojo.AuthProvider;
import com.thunv.pojo.CensorshipAgent;
import com.thunv.pojo.CommentPost;
import com.thunv.pojo.FollowAgent;
import com.thunv.pojo.Gender;
import com.thunv.pojo.LikePost;
import com.thunv.pojo.Orders;
import com.thunv.pojo.RatePost;
import com.thunv.pojo.ReportAgent;
import com.thunv.pojo.ResponseAgent;
import com.thunv.pojo.Role;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-02T17:27:43")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SetAttribute<User, FollowAgent> followAgentSet;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, Gender> gender;
    public static volatile SetAttribute<User, ReportAgent> reportAgentSet;
    public static volatile SetAttribute<User, RatePost> ratePostSet;
    public static volatile SetAttribute<User, Orders> ordersSet;
    public static volatile SingularAttribute<User, Integer> isActive;
    public static volatile SingularAttribute<User, Integer> userID;
    public static volatile SingularAttribute<User, Date> joinedDate;
    public static volatile SetAttribute<User, ResponseAgent> responseAgentSet;
    public static volatile SingularAttribute<User, AuthProvider> authProvider;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, ReportAgent> reportAgentSet1;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SetAttribute<User, CensorshipAgent> censorshipAgentSet;
    public static volatile SetAttribute<User, Agency> agencySet;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, Date> dateOfBirth;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SetAttribute<User, CommentPost> commentPostSet;
    public static volatile SetAttribute<User, CensorshipAgent> censorshipAgentSet1;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SetAttribute<User, LikePost> likePostSet;
    public static volatile SingularAttribute<User, String> username;

}