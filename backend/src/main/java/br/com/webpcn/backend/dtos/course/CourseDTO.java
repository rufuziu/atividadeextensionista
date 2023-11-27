package br.com.webpcn.backend.dtos.course;

public class CourseDTO {
  public CourseDTO() {
  }

  public Integer id;
  public String name;
  public Integer knowledgeAreaId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getKnowledgeAreaId() {
    return knowledgeAreaId;
  }

  public void setKnowledgeAreaId(Integer knowledgeAreaId) {
    this.knowledgeAreaId = knowledgeAreaId;
  }
}
