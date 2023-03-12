package com.example.epma_note_keeping.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "note")
public class Note {
    public Note(final String title, final String description) {
        this.title       = title;
        this.description = description;
    }

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(title, note.title) && Objects.equals(description, note.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
