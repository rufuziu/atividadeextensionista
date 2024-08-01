package br.com.rufuziu.knowledgearea_and_courses.dto;

public class KnowledgeAreaDTO {
    private String id;
    private String name;
    private EducationLevelDTO educationLevel;

    public KnowledgeAreaDTO() {
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

    public EducationLevelDTO getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevelDTO educationLevel) {
        this.educationLevel = educationLevel;
    }
}
