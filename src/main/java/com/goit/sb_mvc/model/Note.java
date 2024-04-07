package com.goit.sb_mvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "notes")
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false)
    @Size(min = 3,max = 100)
    private String title;
    @Column(name = "content")
    @Size(min = 0,max = 1000)
    private String content;
}
