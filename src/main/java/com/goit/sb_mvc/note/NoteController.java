package com.goit.sb_mvc.note;

import com.goit.sb_mvc.note.dto.*;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public CreateNoteResponse create( @RequestBody CreateNoteRequest request) {
        return noteService.create(request);
    }

    @GetMapping
    public GetNotesResponse getNotes() {
        return noteService.getNotes();
    }
    @GetMapping("/{id}")
    public GetNoteResponse getNote(@PathVariable(name = "id") long id) {
        return noteService.getNote(id);
    }

    @PatchMapping
    public UpdateNoteResponse update( @RequestBody UpdateNoteRequest request) {
        return noteService.update(request);
    }

    @DeleteMapping("/{id}")
    public DeleteNoteResponse delete(@PathVariable(name = "id") long id) {
        return noteService.delete(id);
    }
}