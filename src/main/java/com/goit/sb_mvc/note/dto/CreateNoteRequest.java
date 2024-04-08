package com.goit.sb_mvc.note.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNoteRequest {
    private String title;
    private String content;
}