package com.anastasia.notie;


import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<NoteEntity, Integer> {
}
