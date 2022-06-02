package com.github.gregor499.neuefischeaufgabenwoche3springresttemplate.IntegrationsTests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/github")

public class GitHubRepositoryController {

private final GitHubRepositoryService gitHubRepositoryService;

    public GitHubRepositoryController(GitHubRepositoryService gitHubRepositoryService) {
        this.gitHubRepositoryService = gitHubRepositoryService;
    }

    @GetMapping("/{githubUser}")
public List<String> getRepositoryNames(@PathVariable String githubUser) {
    return gitHubRepositoryService.findbyGitHubUser(githubUser);
    }
}
