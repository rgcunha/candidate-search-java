package com.example.candidate.search;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
  public List<Candidate> findByName(String name);
}
