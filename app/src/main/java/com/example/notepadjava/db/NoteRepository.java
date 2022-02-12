package com.example.notepadjava.db;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.notepadjava.datamodel.Note;
import java.util.List;

public class NoteRepository{

    private NoteDao myNoteDao;
    private LiveData<List<Note>> myAllNotes;

    public NoteRepository(Application application){
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        myNoteDao = db.noteDao();
        myAllNotes = myNoteDao.getNoteList();
    }

    public LiveData<List<Note>> getMyAllNotes(){
        return myAllNotes;
    }

    public void insert(Note note){
        NoteRoomDatabase.databaseWriteExecutor.execute(() ->
                myNoteDao.insertNote(note));
    }

    public void delete(Note note){
        NoteRoomDatabase.databaseWriteExecutor.execute(() ->
                myNoteDao.delete(note));
    }

    public void updateNote(Note note){
        NoteRoomDatabase.databaseWriteExecutor.execute(()->
                myNoteDao.updateNote(note));
    }

}

