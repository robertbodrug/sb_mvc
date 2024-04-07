package com.goit.sb_mvc.dao;

import com.goit.sb_mvc.exception.IllegalDataNoteExeption;
import com.goit.sb_mvc.model.Note;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class NoteServi {
    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        return noteRepository.findAll();
    }
    public void add(Note note) throws IllegalDataNoteExeption {
        try {
            noteRepository.save(note);
        }catch (Exception e){
            throw new IllegalDataNoteExeption("<h1>Title must be 3><100 and content must be <1000</h1>");
        }
    }

    public Note getById(Long id){
        Optional<Note> byId = noteRepository.findById(id);
        return byId.orElseGet(Note::new);
    }

    public void update(Note updateNote) throws IllegalDataNoteExeption {
        try {
            noteRepository.save(updateNote);
        }catch (Exception e){
            throw new IllegalDataNoteExeption("Title must be 3><100 and content must be <1000");
        }
    }

    public boolean deleteById(Long id) {
        noteRepository.deleteById(id);
        return true;
    }
}
