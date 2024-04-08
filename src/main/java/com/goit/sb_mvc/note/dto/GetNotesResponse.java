package com.goit.sb_mvc.note.dto;

import com.goit.sb_mvc.note.Note;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class GetNotesResponse {
    private Error error;

    private List<Note> userNotes;

    public enum Error {
        ok,
        notesNotFound
    }

    public static GetNotesResponse success(List<Note> userNotes) {
        return builder().error(Error.ok).userNotes(userNotes).build();
    }

    public static GetNotesResponse failed(Error error) {
        return builder().error(error).userNotes(null).build();
    }
}