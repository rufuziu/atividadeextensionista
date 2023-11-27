package br.com.webpcn.backend.entities.knowledgearea;

import jakarta.persistence.*;

@Entity(name="knowledge_areas")
public class KnowledgeArea {
  public KnowledgeArea() {  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true, length = 128, nullable = false)
  private String name;

  public int getId() {
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
}
