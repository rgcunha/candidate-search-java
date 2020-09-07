package com.example.candidate.search;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateSearchService {
    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateSearchService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    private Integer compareCandidates(Candidate candidate1, Candidate candidate2, Set<String> skills) {
        Set<String> candidate1Skills = getMatchedSkills(candidate1, skills);
        Set<String> candidate2Skills = getMatchedSkills(candidate2, skills);
        return candidate1Skills.size() - candidate2Skills.size();
    }
    
    private Set<String> getMatchedSkills(Candidate candidate, Set<String> requiredSkills) {
        if (candidate == null) return Collections.emptySet();
        return candidate.getSkills()
            .stream()
            .filter(skill -> requiredSkills.contains(skill))
            .collect(Collectors.toSet());
    }
    
    private Boolean isValidCandidate(Candidate candidate, Set<String> skills) {
        Set<String> matchedSkills = getMatchedSkills(candidate, skills);
        return matchedSkills.size() > 0;
    }
    
    public Candidate getBestCandidate(Set<String> skills) {
        List<Candidate> candidateList = candidateRepository.findAll();

        var wrapper = new Object(){ Candidate bestCandidate = null; };
        candidateList.forEach((candidate) -> {
            if (isValidCandidate(candidate, skills)) {
                Integer result = compareCandidates(candidate, wrapper.bestCandidate, skills);
                if (result > 0) { wrapper.bestCandidate = candidate; }
            }
        });
        return wrapper.bestCandidate;
    }

    public Candidate create(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}
