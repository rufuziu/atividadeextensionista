package br.com.webpcn.backend.entities.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "courses")
public class Course {
  public Course() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;

  private Integer knowledgeAreaId;

  public Integer getId() {
    return id;
  }

  public void setId(int id) {
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
