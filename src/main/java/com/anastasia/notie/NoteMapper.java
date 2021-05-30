package com.anastasia.notie;

public class NoteMapper {
    public static Note mapEntityToDomain(NoteEntity noteEntity) {
        return new Note(noteEntity.getId(), noteEntity.getTitle(), noteEntity.getContent());
    }

    public static NoteEntity mapDomainToEntity(Note note) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(note.getId());
        noteEntity.setTitle(note.getTitle());
        noteEntity.setContent(note.getContent());

        return noteEntity;
    }
}
