package br.com.rufuziu.classes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.security.auth.Subject;


@Document(collection = "classes")
public class Class {
    @Id
    private String id;
    private String name;
    private String content;
    private String educationLevelId;
    private String knowledgeAreaId;
    private String subjectId;

    public Class() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(String educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public String getKnowledgeAreaId() {
        return knowledgeAreaId;
    }

    public void setKnowledgeAreaId(String knowledgeAreaId) {
        this.knowledgeAreaId = knowledgeAreaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
