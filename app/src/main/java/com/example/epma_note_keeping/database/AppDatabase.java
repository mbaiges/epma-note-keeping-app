package com.example.epma_note_keeping.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.epma_note_keeping.dao.NoteDao;
import com.example.epma_note_keeping.entities.Note;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    abstract public NoteDao noteDao();

    private static AppDatabase db;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getInstance(Context context) {
        if (db == null) {
            db = buildDatabaseInstance(context);
        }
        return db;
    }

    private static AppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "AppDatabase")
                .allowMainThreadQueries().build();
    }

    public void cleanUp() {
        db = null;
    }
}
