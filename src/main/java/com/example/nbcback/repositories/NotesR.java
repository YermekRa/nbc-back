package com.example.nbcback.repositories;

import com.example.nbcback.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesR extends JpaRepository<Notes, Integer> {
}
