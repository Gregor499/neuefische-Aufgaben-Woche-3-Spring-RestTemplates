package com.github.gregor499.neuefischeaufgabenwoche3springresttemplate.RestTemplate;

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

public class RepositoryController {

    @GetMapping("/{githubUser}")
public List<String> getRepositoryNames(@PathVariable String githubUser) {
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("https://api.github.com/users/" + githubUser + "/repos", Repository[].class)))
                .map(Repository::getName).toList();
    }
}
