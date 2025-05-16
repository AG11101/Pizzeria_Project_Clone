package ch.fhnw.pizza.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @GetMapping("/nla")
    public ResponseEntity<String> getNlaJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("JSON NLA");
        String json = Files.readString(resource.getFile().toPath());
        return ResponseEntity.ok(json);
    }

    @GetMapping("/players")
    public ResponseEntity<String> getNlaPlayersJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("JSON NLA PLAYERS");
        String json = Files.readString(resource.getFile().toPath());
        return ResponseEntity.ok(json);
    }
}
