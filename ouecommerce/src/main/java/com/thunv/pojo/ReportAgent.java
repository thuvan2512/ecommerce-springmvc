/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu.nv2512
 */
@Entity
@Table(name = "report_agent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportAgent.findAll", query = "SELECT r FROM ReportAgent r"),
    @NamedQuery(name = "ReportAgent.findByReportID", query = "SELECT r FROM ReportAgent r WHERE r.reportID = :reportID"),
    @NamedQuery(name = "ReportAgent.findByTitle", query = "SELECT r FROM ReportAgent r WHERE r.title = :title"),
    @NamedQuery(name = "ReportAgent.findByContent", query = "SELECT r FROM ReportAgent r WHERE r.content = :content"),
    @NamedQuery(name = "ReportAgent.findBySettlementState", query = "SELECT r FROM ReportAgent r WHERE r.settlementState = :settlementState")})
public class ReportAgent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportID")
    private Integer reportID;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 200)
    @Column(name = "content")
    private String content;
    @Column(name = "settlement_state")
    private Integer settlementState;
    @JoinColumn(name = "agencyID", referencedColumnName = "agencyID")
    @ManyToOne
    private Agency agencyID;
    @JoinColumn(name = "sensorID", referencedColumnName = "userID")
    @ManyToOne
    private User sensorID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User userID;

    public ReportAgent() {
    }

    public ReportAgent(Integer reportID) {
        this.reportID = reportID;
    }

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSettlementState() {
        return settlementState;
    }

    public void setSettlementState(Integer settlementState) {
        this.settlementState = settlementState;
    }

    public Agency getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(Agency agencyID) {
        this.agencyID = agencyID;
    }

    public User getSensorID() {
        return sensorID;
    }

    public void setSensorID(User sensorID) {
        this.sensorID = sensorID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportID != null ? reportID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportAgent)) {
            return false;
        }
        ReportAgent other = (ReportAgent) object;
        if ((this.reportID == null && other.reportID != null) || (this.reportID != null && !this.reportID.equals(other.reportID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thunv.pojo.ReportAgent[ reportID=" + reportID + " ]";
    }
    
}
