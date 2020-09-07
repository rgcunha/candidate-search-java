package com.example.candidate.search;

import java.util.Set;

import org.springframework.data.annotation.Id;

public class Candidate {

  @Id private String id;

  private Set<String> skills;
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getSkills() {
    return skills;
  }

  public void setSkills(Set<String> skills) {
    this.skills = skills;
  }
}
