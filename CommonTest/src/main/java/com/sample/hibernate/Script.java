package com.sample.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SCRIPT")
public class Script implements Identifiable {
    private static final long serialVersionUID = 2282409167266759777L;

    @Id
    @Column(name = "SCRIPT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SCRIPT_RELEASE",
            joinColumns = { @JoinColumn(name = "SCRIPT_ID", referencedColumnName = "SCRIPT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "RELEASE_ID", referencedColumnName = "RELEASE_ID") })
    private List<Release> releases;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTER_ID", nullable = false)
    private User requester;

    @Column(name = "JIRA", nullable = false, length = 10)
    private String jira;

    @Column(name = "REQUEST_DATE", nullable = false)
    private Date requestDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SCRIPT_CLIENT",
            joinColumns = { @JoinColumn(name = "SCRIPT_ID", referencedColumnName = "SCRIPT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID") })
    private List<Client> clients;

    @Column(name = "SUMMARY", nullable = false, length = 100)
    private String summary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "script", cascade = CascadeType.ALL)
    private List<Section> sections;

    @Column(name = "PROCESSED_DATE")
    private Date processedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 10)
    private Status status;

    @Override
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public String getJira() {
        return jira;
    }

    public void setJira(String jira) {
        this.jira = jira;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
