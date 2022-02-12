package com.example.notepadjava.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notepadjava.datamodel.Note;
import com.example.notepadjava.db.NoteRepository;

import java.util.List;

public class ShareViewModel extends AndroidViewModel {

    private NoteRepository myRepository;
    private final LiveData<List<Note>> allNote;


    public ShareViewModel(@NonNull Application application) {
        super(application);
        myRepository = new NoteRepository(application);
        allNote = myRepository.getMyAllNotes();
    }

    public LiveData<List<Note>> getAllNote() {
        return allNote;
    }

    public void insert(Note note) {
        myRepository.insert(note);
    }

    public void delete(Note note) {
        myRepository.delete(note);
    }


}