package com.example.notepadjava.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note implements Parcelable {

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

        protected Note(Parcel in) {
                id = in.readInt();
                title = in.readString();
                description = in.readString();
        }

        public static final Creator<Note> CREATOR = new Creator<Note>() {
                @Override
                public Note createFromParcel(Parcel in) {
                        return new Note(in);
                }

                @Override
                public Note[] newArray(int size) {
                        return new Note[size];
                }
        };

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

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(id);
                dest.writeString(title);
                dest.writeString(description);
        }
}