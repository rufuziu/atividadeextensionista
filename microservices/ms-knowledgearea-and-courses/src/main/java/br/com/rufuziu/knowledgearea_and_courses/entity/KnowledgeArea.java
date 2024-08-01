package br.com.rufuziu.knowledgearea_and_courses.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "knowledgeareas")
public class KnowledgeArea {
    @Id
    private String id;
    private String name;
    @DBRef
    private EducationLevel educationLevel;

    public KnowledgeArea() {
    }

    public KnowledgeArea(String name, EducationLevel educationLevel) {
        this.name = name;
        this.educationLevel = educationLevel;
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

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
}
