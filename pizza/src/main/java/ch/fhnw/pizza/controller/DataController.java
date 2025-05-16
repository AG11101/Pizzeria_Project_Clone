package ch.fhnw.pizza.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @GetMapping("/players")
    public ResponseEntity<String> getPlayersJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("JSON NLA PLAYERS");
        String json = Files.readString(resource.getFile().toPath());
        return ResponseEntity.ok(json);
    }
}