package com.example.epma_note_keeping.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.epma_note_keeping.entities.Note;
import com.example.epma_note_keeping.repositories.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    NoteRepository repository;

    private final LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.findAll();
    }

    public void insert(Note note) {
        repository.insert(note);
    }

    public LiveData<List<Note>> findAll() {
        return allNotes;
    }

    public LiveData<Note> findById(Integer id) {
        return repository.findById(id);
    }

    public void update(Note note) {
        repository.update(note);
    }

    public void delete(Note note) {
        repository.delete(note);
    }
}
