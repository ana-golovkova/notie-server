package com.anastasia.notie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class NotesController {

    @Autowired
    private NoteRepository noteRepository;


    @GetMapping("/notes")
    public List<Note> getNotes() {

        Iterable<NoteEntity> noteEntities = noteRepository.findAll();

        List<NoteEntity> noteEntityList = new ArrayList<>();
        noteEntities.forEach(noteEntityList::add);

        return noteEntityList.stream().map(NoteMapper::mapEntityToDomain).collect(Collectors.toList());

    }

    @GetMapping("/note")
    public Note getNote(@RequestParam int id) {
        Optional<NoteEntity> noteEntity = noteRepository.findById(id);
        if (noteEntity.isPresent()) {
            return NoteMapper.mapEntityToDomain(noteEntity.get());
        } else {
            throw new NoteNotFoundException();
        }
    }

    @PostMapping("/note")
    public Note postNote(@RequestBody Note note) {
        NoteEntity noteEntity = NoteMapper.mapDomainToEntity(note);
        noteEntity.setId(null);
        return NoteMapper.mapEntityToDomain(noteRepository.save(noteEntity));
    }

    @PutMapping("/note")
    public Note editNote(@RequestBody Note note) {
        NoteEntity noteEntity = NoteMapper.mapDomainToEntity(note);
        if (noteRepository.existsById(noteEntity.getId())) {
            return NoteMapper.mapEntityToDomain(noteRepository.save(noteEntity));
        } else {
            throw new NoteNotFoundException();
        }
    }

    @DeleteMapping("/note")
    public void deleteNote(@RequestParam int id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException();
        }
    }

}
