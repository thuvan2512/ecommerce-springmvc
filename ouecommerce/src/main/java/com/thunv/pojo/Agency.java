/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "agency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agency.findAll", query = "SELECT a FROM Agency a"),
    @NamedQuery(name = "Agency.findByAgencyID", query = "SELECT a FROM Agency a WHERE a.agencyID = :agencyID"),
    @NamedQuery(name = "Agency.findByName", query = "SELECT a FROM Agency a WHERE a.name = :name"),
    @NamedQuery(name = "Agency.findByIsActive", query = "SELECT a FROM Agency a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "Agency.findByAvatar", query = "SELECT a FROM Agency a WHERE a.avatar = :avatar"),
    @NamedQuery(name = "Agency.findByCoverImage", query = "SELECT a FROM Agency a WHERE a.coverImage = :coverImage"),
    @NamedQuery(name = "Agency.findByAddress", query = "SELECT a FROM Agency a WHERE a.address = :address"),
    @NamedQuery(name = "Agency.findByHotline", query = "SELECT a FROM Agency a WHERE a.hotline = :hotline"),
    @NamedQuery(name = "Agency.findByCreatedDate", query = "SELECT a FROM Agency a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "Agency.findByIsCensored", query = "SELECT a FROM Agency a WHERE a.isCensored = :isCensored")})
public class Agency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agencyID")
    private Integer agencyID;
    @Basic(optional = false)
    @NotNull(message = "{message.err.notNull}")
    @Size(min = 1, max = 50,message = "{message.err.agencyname.size}")
    @Column(name = "name")
    private String name;
    @Column(name = "isActive")
    private Integer isActive;
    @Size(max = 200)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 200)
    @Column(name = "coverImage")
    private String coverImage;
    @Basic(optional = false)
    @NotNull(message = "{message.err.notNull}")
    @Size(min = 1, max = 500,message = "{message.err.address.size}")
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "hotline")
    private String hotline;
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "isCensored")
    private Integer isCensored;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<CensorshipAgent> censorshipAgentSet;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<OrderAgent> orderAgentSet;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<VoucherAgent> voucherAgentSet;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<ReportAgent> reportAgentSet;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<FollowAgent> followAgentSet;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<SalePost> salePostSet;
    @JoinColumn(name = "field", referencedColumnName = "afID")
    @ManyToOne
    @JsonIgnoreProperties({"agencySet"})
    private AgentField field;
    @JoinColumn(name = "manager", referencedColumnName = "userID")
    @ManyToOne
    @JsonIgnore
    private User manager;
    @OneToMany(mappedBy = "agencyID")
    @JsonIgnore
    private Set<ResponseAgent> responseAgentSet;
    @Transient
    @JsonIgnore
    private MultipartFile fileAvatar;
    @Transient
    @JsonIgnore
    private MultipartFile fileAvatarUpdate;

    public MultipartFile getFileAvatarUpdate() {
        return fileAvatarUpdate;
    }

    public void setFileAvatarUpdate(MultipartFile fileAvatarUpdate) {
        this.fileAvatarUpdate = fileAvatarUpdate;
    }

    public MultipartFile getFileAvatar() {
        return fileAvatar;
    }

    public void setFileAvatar(MultipartFile fileAvatar) {
        this.fileAvatar = fileAvatar;
    }
    public Agency() {
    }

    public Agency(Integer agencyID) {
        this.agencyID = agencyID;
    }

    public Agency(Integer agencyID, String name, String address) {
        this.agencyID = agencyID;
        this.name = name;
        this.address = address;
    }

    public Integer getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Integer agencyID) {
        this.agencyID = agencyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getIsCensored() {
        return isCensored;
    }

    public void setIsCensored(Integer isCensored) {
        this.isCensored = isCensored;
    }

    @XmlTransient
    public Set<CensorshipAgent> getCensorshipAgentSet() {
        return censorshipAgentSet;
    }

    public void setCensorshipAgentSet(Set<CensorshipAgent> censorshipAgentSet) {
        this.censorshipAgentSet = censorshipAgentSet;
    }

    @XmlTransient
    public Set<OrderAgent> getOrderAgentSet() {
        return orderAgentSet;
    }

    public void setOrderAgentSet(Set<OrderAgent> orderAgentSet) {
        this.orderAgentSet = orderAgentSet;
    }

    @XmlTransient
    public Set<VoucherAgent> getVoucherAgentSet() {
        return voucherAgentSet;
    }

    public void setVoucherAgentSet(Set<VoucherAgent> voucherAgentSet) {
        this.voucherAgentSet = voucherAgentSet;
    }

    @XmlTransient
    public Set<ReportAgent> getReportAgentSet() {
        return reportAgentSet;
    }

    public void setReportAgentSet(Set<ReportAgent> reportAgentSet) {
        this.reportAgentSet = reportAgentSet;
    }

    @XmlTransient
    public Set<FollowAgent> getFollowAgentSet() {
        return followAgentSet;
    }

    public void setFollowAgentSet(Set<FollowAgent> followAgentSet) {
        this.followAgentSet = followAgentSet;
    }

    @XmlTransient
    public Set<SalePost> getSalePostSet() {
        return salePostSet;
    }

    public void setSalePostSet(Set<SalePost> salePostSet) {
        this.salePostSet = salePostSet;
    }

    public AgentField getField() {
        return field;
    }

    public void setField(AgentField field) {
        this.field = field;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @XmlTransient
    public Set<ResponseAgent> getResponseAgentSet() {
        return responseAgentSet;
    }

    public void setResponseAgentSet(Set<ResponseAgent> responseAgentSet) {
        this.responseAgentSet = responseAgentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agencyID != null ? agencyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agency)) {
            return false;
        }
        Agency other = (Agency) object;
        if ((this.agencyID == null && other.agencyID != null) || (this.agencyID != null && !this.agencyID.equals(other.agencyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.Agency[ agencyID=" + agencyID + " ]";
    }
    
}
