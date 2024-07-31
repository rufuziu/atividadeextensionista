package br.com.rufuziu.knowledgearea_and_courses.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "educationlevels")
public class EducationLevel {
    @Id
    private String id;
    private String name;

    public EducationLevel() {
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
}
