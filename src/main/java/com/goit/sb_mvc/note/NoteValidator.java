package com.goit.sb_mvc.note;

import com.goit.sb_mvc.note.dto.CreateNoteRequest;
import com.goit.sb_mvc.note.dto.CreateNoteResponse;
import com.goit.sb_mvc.note.dto.UpdateNoteRequest;
import com.goit.sb_mvc.note.dto.UpdateNoteResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;
import java.util.Optional;
@Component
public class NoteValidator {
    private static final int MAX_TITLE_LENGTH = 50;
    private static final int MAX_CONTENT_LENGTH = 1000;
    public Optional<CreateNoteResponse.Error> validateCreateFields(CreateNoteRequest request) {
        if (Objects.isNull(request.getTitle()) || request.getTitle().length() > MAX_TITLE_LENGTH) {
            return Optional.of(CreateNoteResponse.Error.invalidTitle);
        }

        if (Objects.isNull(request.getContent()) || request.getContent().length() > MAX_CONTENT_LENGTH) {
            return Optional.of(CreateNoteResponse.Error.invalidContent);
        }

        return Optional.empty();
    }

    public Optional<UpdateNoteResponse.Error> validateUpdateFields(UpdateNoteRequest request) {
        if (Objects.nonNull(request.getTitle()) && request.getTitle().length() > MAX_TITLE_LENGTH) {
            return Optional.of(UpdateNoteResponse.Error.invalidTitleLength);
        }

        if (Objects.nonNull(request.getContent()) && request.getContent().length() > MAX_CONTENT_LENGTH) {
            return Optional.of(UpdateNoteResponse.Error.invalidContentLength);
        }

        return Optional.empty();
    }

}
