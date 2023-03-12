package com.example.epma_note_keeping.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.epma_note_keeping.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert()
    void insert(Note note);

    @Query("SELECT * FROM note")
    LiveData<List<Note>> findAll();

    @Query("SELECT * FROM note WHERE id=:id LIMIT 1")
    LiveData<Note> findById(Integer id);

    @Update()
    void update(Note note);

    @Delete()
    void delete(Note note);
}
