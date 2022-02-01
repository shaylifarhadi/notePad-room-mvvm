package com.example.notepadjava.datamodel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

        @NonNull
        @ColumnInfo(name = "id")
        @PrimaryKey(autoGenerate = true)
        private int id = 0;

        @NonNull
        @ColumnInfo(name = "title")
        private String title;

        @NonNull
        @ColumnInfo(name = "desc")
        private String description;

        public Note(@NonNull String title, @NonNull String description) {
                this.title = title;
                this.description = description;
                this.id = id;
        }

        @NonNull
        public String getTitle() {
                return title;
        }

        @NonNull
        public String getDescription() {
                return description;
        }

        public int getId() {
                return id;
        }


        public void setId(int id) {
                this.id = id;
        }

        public void setTitle(@NonNull String title) {
                this.title = title;
        }

        public void setDescription(@NonNull String description) {
                this.description = description;
        }
}