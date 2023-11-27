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
  private long id;
  private String name;

  private int knowledgeAreaId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKnowledgeAreaId() {
    return knowledgeAreaId;
  }

  public void setKnowledgeAreaId(int knowledgeAreaId) {
    this.knowledgeAreaId = knowledgeAreaId;
  }
}
