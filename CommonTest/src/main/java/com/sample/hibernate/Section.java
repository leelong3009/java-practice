package com.sample.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SECTION")
public class Section implements Identifiable {
    private static final long serialVersionUID = 7709069655982333381L;

    @Id
    @Column(name = "SECTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_NO", nullable = false)
    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCRIPT_ID", nullable = false)
    private Script script;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SECTION_CLIENT",
            joinColumns = { @JoinColumn(name="SECTION_ID", referencedColumnName="SECTION_ID") },
            inverseJoinColumns = { @JoinColumn(name="CLIENT_ID", referencedColumnName="CLIENT_ID") })
    private List<Client> clients;

    @Column(name = "COMMENT", length = 4000)
    private String comment;

    @Column(name = "CONTENT", length = 10000)
    private String content;

    @Override
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
