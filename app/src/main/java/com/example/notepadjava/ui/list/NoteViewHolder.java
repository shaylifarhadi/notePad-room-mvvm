package com.example.notepadjava.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notepadjava.R;

import androidx.recyclerview.widget.RecyclerView;

class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView noteItemView;

    public NoteViewHolder(View itemView) {
        super(itemView);
        noteItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        noteItemView.setText(text);
    }

    static NoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

}
