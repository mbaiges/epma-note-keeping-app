package com.example.epma_note_keeping.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.epma_note_keeping.R;
import com.example.epma_note_keeping.entities.Note;
import com.example.epma_note_keeping.viewmodel.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNoteFragment extends Fragment {

    // ViewModel
    private NoteViewModel noteViewModel;

    // UI
    private EditText noteTitleText, noteDescriptionText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        // Set title
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.fragment_title_add_note);

        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noteTitleText       = view.findViewById(R.id.create_note_title_edit_text);
        noteDescriptionText = view.findViewById(R.id.create_note_description_edit_text);

        FloatingActionButton fab = view.findViewById(R.id.save_note);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String title       = noteTitleText.getText().toString();
                final String description = noteDescriptionText.getText().toString();
                if (title.isEmpty() || title.trim().isEmpty()
                        || description.isEmpty() || description.trim().isEmpty()) {
                    // Don't add if there is no text, should show an error/warning
                    return;
                }
                final Note newNote = new Note(title, description);
                noteViewModel.insert(newNote);
                Navigation.findNavController(view).popBackStack();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
