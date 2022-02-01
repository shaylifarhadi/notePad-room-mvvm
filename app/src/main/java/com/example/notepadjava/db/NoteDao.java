package com.example.notepadjava.db;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.example.notepadjava.datamodel.Note;
import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNote(Note note);

    @Update
    void updateNote(Note note);

    @Delete
    void delete(Note note);

    @Query("select * from note_table order by id asc")
    LiveData<List<Note>> getNoteList();
}
