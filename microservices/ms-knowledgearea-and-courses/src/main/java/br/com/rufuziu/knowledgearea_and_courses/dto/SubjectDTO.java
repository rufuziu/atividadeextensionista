package br.com.rufuziu.knowledgearea_and_courses.dto;

public class SubjectDTO {
    private String id;
    private String name;
    private String content;
    private KnowledgeAreaDTO knowledgeAreaDto;

    public SubjectDTO() {
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

    public KnowledgeAreaDTO getKnowledgeAreaDto() {
        return knowledgeAreaDto;
    }

    public void setKnowledgeAreaDto(KnowledgeAreaDTO knowledgeAreaDto) {
        this.knowledgeAreaDto = knowledgeAreaDto;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
