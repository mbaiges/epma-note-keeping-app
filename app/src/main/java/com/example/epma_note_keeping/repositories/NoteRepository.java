package com.example.epma_note_keeping.repositories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.epma_note_keeping.dao.NoteDao;
import com.example.epma_note_keeping.database.AppDatabase;
import com.example.epma_note_keeping.entities.Note;

import java.util.List;

public class NoteRepository {

    final private AppDatabase          db;
    final private NoteDao              noteDao;
    final private LiveData<List<Note>> allNotes;

    public NoteRepository(@NonNull Application application) {
        db       = AppDatabase.getInstance(application.getApplicationContext());
        noteDao  = db.noteDao();
        allNotes = noteDao.findAll();
    }

    public void insert(Note note) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            noteDao.insert(note);
        });
    }

    public LiveData<List<Note>> findAll() {
        return allNotes;
    }

    public LiveData<Note> findById(Integer id) {
        return noteDao.findById(id);
    }

    public void update(Note note) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            noteDao.update(note);
        });
    }

    public void delete(Note note) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            noteDao.delete(note);
        });
    }
}
