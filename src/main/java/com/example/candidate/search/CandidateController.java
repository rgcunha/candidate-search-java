package com.example.candidate.search;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {
	private CandidateSearchService candidateSearchService;
	
    @Autowired
    public CandidateController(CandidateSearchService candidateSearchService) {
        this.candidateSearchService = candidateSearchService;
    }

	@GetMapping("/candidates")
	public Candidate findBestCandidate(@RequestParam(value = "skills") Set<String> skills) {
		return this.candidateSearchService.getBestCandidate(skills);
	}
	
	@PostMapping("/candidates")
	@ResponseStatus(HttpStatus.CREATED)
	public Candidate createCandidate(@RequestBody Candidate candidate) {
		return this.candidateSearchService.create(candidate);
	}
}
