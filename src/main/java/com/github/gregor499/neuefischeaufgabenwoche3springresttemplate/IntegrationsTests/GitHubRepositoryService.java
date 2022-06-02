package com.github.gregor499.neuefischeaufgabenwoche3springresttemplate.IntegrationsTests;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class GitHubRepositoryService {
    public List<String> findbyGitHubUser(String githubUser) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("https://api.github.com/users/" + githubUser + "/repos", GitHubRepository[].class)))
                .map(GitHubRepository::getName).toList();
    }
}
