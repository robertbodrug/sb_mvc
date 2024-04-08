package com.goit.sb_mvc.note;

import com.goit.sb_mvc.note.dto.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class NoteService {

    private final NoteRepository repository;
    private final NoteValidator validator;
    public CreateNoteResponse create(CreateNoteRequest request) {
        Optional<CreateNoteResponse.Error> validationError = validator.validateCreateFields(request);

        if (validationError.isPresent()) {
            return CreateNoteResponse.failed(validationError.get());
        }
        Note createdNote = repository.save(Note.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());

        return CreateNoteResponse.success(createdNote.getId());
    }

    public GetNoteResponse getNote( @RequestParam(name = "id") long id) {
        Optional<Note> byId = repository.findById(id);
        if(byId.isEmpty()){
            return GetNoteResponse.failed(GetNoteResponse.Error.noteNotFound);
        }else {
            return GetNoteResponse.success(byId.get());
        }
    }

    public GetNotesResponse getNotes() {
        List<Note> notes = repository.findAll();
        log.info(notes.toString());
        if(notes.isEmpty()){
            return GetNotesResponse.failed(GetNotesResponse.Error.notesNotFound);
        }else {
        return GetNotesResponse.success(notes);
        }
    }

    public UpdateNoteResponse update( UpdateNoteRequest request) {
        Optional<Note> optionalNote = repository.findById(request.getId());

        if (optionalNote.isEmpty()) {
            return UpdateNoteResponse.failed(UpdateNoteResponse.Error.invalidNoteId);
        }

        Note note = optionalNote.get();

        Optional<UpdateNoteResponse.Error> validationError = validator.validateUpdateFields(request);

        if (validationError.isPresent()) {
            return UpdateNoteResponse.failed(validationError.get());
        }

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        repository.save(note);

        return UpdateNoteResponse.success(note);
    }

    public DeleteNoteResponse delete(long id) {
        Optional<Note> optionalNote = repository.findById(id);

        if (optionalNote.isEmpty()) {
            return DeleteNoteResponse.failed(DeleteNoteResponse.Error.invalidNoteId);
        }

        Note note = optionalNote.get();

        repository.delete(note);

        return DeleteNoteResponse.success();
    }


}
