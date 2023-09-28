package com.example.nbcback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "notes")
@SequenceGenerator(name = "notes_id_seq", sequenceName = "notes_id_seq", allocationSize = 1)
public class Notes {

    @Id
    private long id;

    @Column(name = "author")
    private String userName;

    @Column(name = "added")
    private Date added;

    @Column(name = "title")
    private String title;

    @Column(name = "note")
    private String note;

}
