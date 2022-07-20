package com.challenge.backend.note.domain.persistance;

import com.challenge.backend.note.domain.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

}

