package com.example.epma_note_keeping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.epma_note_keeping.R;
import com.example.epma_note_keeping.entities.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleTextView, descriptionTextView;
    public NoteViewHolder(View view) {
        super(view);
        titleTextView       = view.findViewById(R.id.title);
        descriptionTextView = view.findViewById(R.id.description);
    }

    public void bind(Note note) {
        titleTextView.setText(note.title);
        descriptionTextView.setText(note.description);
    }

    static NoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }
}
