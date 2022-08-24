/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByIsActive", query = "SELECT u FROM User u WHERE u.isActive = :isActive"),
    @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
    @NamedQuery(name = "User.findByJoinedDate", query = "SELECT u FROM User u WHERE u.joinedDate = :joinedDate")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
    @Column(name = "isActive")
    private Integer isActive = 1;
    @Size(max = 300)
    @Column(name = "avatar")
    private String avatar;
    @Basic(optional = false)
    @NotNull(message = "{message.err.notNull}")
    @Size(min = 5, max = 50,message = "{message.err.username.size}")
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull(message = "{message.err.notNull}")
    @Size(min = 6, max = 200,message = "{message.err.password.size}")
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="{message.err.email.invalid}")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull(message = "{message.err.notNull}")
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    //@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    @Column(name = "joinedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedDate;
    @OneToMany(mappedBy = "userID")
    private Set<CensorshipAgent> censorshipAgentSet;
    @OneToMany(mappedBy = "censorID")
    private Set<CensorshipAgent> censorshipAgentSet1;
    @OneToMany(mappedBy = "sensorID")
    private Set<ReportAgent> reportAgentSet;
    @OneToMany(mappedBy = "userID")
    private Set<ReportAgent> reportAgentSet1;
    @OneToMany(mappedBy = "userID")
    private Set<Orders> ordersSet;
    @OneToMany(mappedBy = "userID")
    private Set<FollowAgent> followAgentSet;
    @OneToMany(mappedBy = "manager")
    private Set<Agency> agencySet;
    @OneToMany(mappedBy = "userID")
    private Set<CommentPost> commentPostSet;
    @OneToMany(mappedBy = "userID")
    private Set<LikePost> likePostSet;
    @OneToMany(mappedBy = "userID")
    private Set<ResponseAgent> responseAgentSet;
    @OneToMany(mappedBy = "userID")
    private Set<RatePost> ratePostSet;
    @JoinColumn(name = "authProvider", referencedColumnName = "authID")
    @ManyToOne
    private AuthProvider authProvider;
    @JoinColumn(name = "gender", referencedColumnName = "genderID")
    @ManyToOne
    private Gender gender;
    @JoinColumn(name = "role", referencedColumnName = "roleID")
    @ManyToOne
    private Role role;
    @Transient
    private MultipartFile fileAvatar;
//    @AssertTrue(message = "File must be provided")
//    public boolean isFileProvided() {
//      return (fileAvatar != null);
//    }
    @Transient
    private String rePassword;

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
    
    public MultipartFile getFileAvatar() {
        return fileAvatar;
    }

    public void setFileAvatar(MultipartFile fileAvatar) {
        this.fileAvatar = fileAvatar;
    }
    
    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public User(Integer userID, String username, String password, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @XmlTransient
    public Set<CensorshipAgent> getCensorshipAgentSet() {
        return censorshipAgentSet;
    }

    public void setCensorshipAgentSet(Set<CensorshipAgent> censorshipAgentSet) {
        this.censorshipAgentSet = censorshipAgentSet;
    }

    @XmlTransient
    public Set<CensorshipAgent> getCensorshipAgentSet1() {
        return censorshipAgentSet1;
    }

    public void setCensorshipAgentSet1(Set<CensorshipAgent> censorshipAgentSet1) {
        this.censorshipAgentSet1 = censorshipAgentSet1;
    }

    @XmlTransient
    public Set<ReportAgent> getReportAgentSet() {
        return reportAgentSet;
    }

    public void setReportAgentSet(Set<ReportAgent> reportAgentSet) {
        this.reportAgentSet = reportAgentSet;
    }

    @XmlTransient
    public Set<ReportAgent> getReportAgentSet1() {
        return reportAgentSet1;
    }

    public void setReportAgentSet1(Set<ReportAgent> reportAgentSet1) {
        this.reportAgentSet1 = reportAgentSet1;
    }

    @XmlTransient
    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    @XmlTransient
    public Set<FollowAgent> getFollowAgentSet() {
        return followAgentSet;
    }

    public void setFollowAgentSet(Set<FollowAgent> followAgentSet) {
        this.followAgentSet = followAgentSet;
    }

    @XmlTransient
    public Set<Agency> getAgencySet() {
        return agencySet;
    }

    public void setAgencySet(Set<Agency> agencySet) {
        this.agencySet = agencySet;
    }

    @XmlTransient
    public Set<CommentPost> getCommentPostSet() {
        return commentPostSet;
    }

    public void setCommentPostSet(Set<CommentPost> commentPostSet) {
        this.commentPostSet = commentPostSet;
    }

    @XmlTransient
    public Set<LikePost> getLikePostSet() {
        return likePostSet;
    }

    public void setLikePostSet(Set<LikePost> likePostSet) {
        this.likePostSet = likePostSet;
    }

    @XmlTransient
    public Set<ResponseAgent> getResponseAgentSet() {
        return responseAgentSet;
    }

    public void setResponseAgentSet(Set<ResponseAgent> responseAgentSet) {
        this.responseAgentSet = responseAgentSet;
    }

    @XmlTransient
    public Set<RatePost> getRatePostSet() {
        return ratePostSet;
    }

    public void setRatePostSet(Set<RatePost> ratePostSet) {
        this.ratePostSet = ratePostSet;
    }

    public AuthProvider getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.User[ userID=" + userID + " ]";
    }
    
}
