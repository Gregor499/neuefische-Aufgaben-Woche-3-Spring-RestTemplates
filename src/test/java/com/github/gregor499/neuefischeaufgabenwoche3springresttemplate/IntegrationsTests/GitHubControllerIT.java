package com.github.gregor499.neuefischeaufgabenwoche3springresttemplate.IntegrationsTests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class GitHubControllerIT {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private GitHubRepositoryService gitHubRepositoryService;

/*    @Test
    void shouldGetReposFromUserWithoutMock(){
        //GIVEN
        String name = "chrisweber1408";
        List<String> repos = List.of("FirstSpringBootProject",
                "FreitagsaufgabeWeek2",
                "Github-Aufgabe1",
                "Test",
                "Week1",
                "Week2_Uebungen");

        //WHEN
        ResponseEntity<String[]> acutal = restTemplate.getForEntity("/github/" + name, String[].class);
        Assertions.assertThat(acutal.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(acutal.getBody()).containsAll(repos);
    }*/

    @Test
    void shouldGetReposFromUser(){
        //GIVEN
        String name = "chrisweber1408";
        List<String> repos = List.of("FirstSpringBootProject",
                "FreitagsaufgabeWeek2",
                "Github-Aufgabe1",
                "Test",
                "Week1",
                "Week2_Uebungen");

        when(gitHubRepositoryService.findbyGitHubUser(name)).thenReturn(repos);

        //WHEN
        ResponseEntity<String[]> acutal = restTemplate.getForEntity("/github/" + name, String[].class);
        Assertions.assertThat(acutal.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(acutal.getBody()).containsAll(repos);
    }
}
