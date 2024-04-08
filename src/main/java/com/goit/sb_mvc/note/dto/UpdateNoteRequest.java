package com.goit.sb_mvc.note.dto;

import lombok.Data;

@Data
public class UpdateNoteRequest {
    private long id;
    private String title;
    private String content;
}