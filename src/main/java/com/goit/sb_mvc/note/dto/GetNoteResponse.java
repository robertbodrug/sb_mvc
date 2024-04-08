package com.goit.sb_mvc.note.dto;

import com.goit.sb_mvc.note.Note;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetNoteResponse {
    private GetNoteResponse.Error error;

    private Note note;

    public enum Error {
        ok,
        noteNotFound
    }

    public static GetNoteResponse success(Note note) {
        return builder().error(GetNoteResponse.Error.ok).note(note).build();
    }

    public static GetNoteResponse failed(GetNoteResponse.Error error) {
        return builder().error(error).note(null).build();
    }
}
