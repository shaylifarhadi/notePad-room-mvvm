package com.example.notepadjava.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepadjava.R;
import com.example.notepadjava.datamodel.Note;

public class NoteListAdapter extends ListAdapter<Note, NoteListAdapter.NoteViewHolder> {

    private static ClickListener onClickDelete;

    protected NoteListAdapter(@NonNull DiffUtil.ItemCallback<Note> diffCallback,
                              ClickListener onClickDelete) {
        super(diffCallback);

        this.onClickDelete = onClickDelete;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NoteListAdapter.NoteViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note data = getItem(position);
        if (data != null) {
            holder.bind(data);
            holder.bind(data);
        }

    }

    static class NoteDiff extends DiffUtil.ItemCallback<Note> {

        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getDescription().equals(newItem.getDescription());
        }
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvTitle, tvDescription;
        private ImageView imgDelete;

        public NoteViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            imgDelete = itemView.findViewById(R.id.img_delete);
            imgDelete.setOnClickListener(this);
        }

        public void bind(Note data) {
            tvTitle.setText(data.getTitle());
            tvDescription.setText(data.getDescription());
            imgDelete.setImageResource(R.drawable.ic_baseline_delete_24);
        }

        public static NoteViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_note, parent, false);
            return new NoteViewHolder(view);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (view.getId() == R.id.img_delete) {
                onClickDelete.onDeleteClick(view, position);
            }
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        NoteListAdapter.onClickDelete = clickListener;
    }

    interface ClickListener {
        void onDeleteClick(View view, int position);
    }
}
