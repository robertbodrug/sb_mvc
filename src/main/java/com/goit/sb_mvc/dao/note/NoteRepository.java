package com.goit.sb_mvc.dao.note;

import com.goit.sb_mvc.model.Note;
import com.goit.sb_mvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}
