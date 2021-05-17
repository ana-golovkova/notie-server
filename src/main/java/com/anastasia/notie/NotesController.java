package com.anastasia.notie;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NotesController {

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return List.of(new Note(1, "title", "content"));
    }

    @PostMapping("/note")
    public Note postNote(@RequestBody Note note) {
        return note;
    }

    @PutMapping("/note")
    public Note editNote(@RequestBody Note note) {
        return note;
    }

    @DeleteMapping("/note")
    public void deleteNote(@RequestParam int id){

    }

}
