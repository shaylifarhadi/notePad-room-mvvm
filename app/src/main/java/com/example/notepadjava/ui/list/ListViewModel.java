package com.example.notepadjava.ui.list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notepadjava.datamodel.Note;
import com.example.notepadjava.db.NoteRepository;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private NoteRepository myRepository;
    private final LiveData<List<Note>> allNote;

    public ListViewModel(@NonNull Application application) {
        super(application);
        myRepository = new NoteRepository(application);
        allNote = myRepository.getMyAllNotes();
    }
    LiveData<List<Note>> getAllNote() {
        return allNote;
    }
    public void insert(Note note) {
        myRepository.insert(note);
    }
}