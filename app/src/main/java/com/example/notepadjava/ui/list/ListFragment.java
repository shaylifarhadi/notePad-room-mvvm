package com.example.notepadjava.ui.list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepadjava.R;
import com.example.notepadjava.datamodel.Note;
import com.example.notepadjava.ui.ShareViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ListFragment extends Fragment implements NoteListAdapter.ClickListener {

    private static final String TAG = "TAG";
    private NavController navController;
    private RecyclerView recyclerView;
    private FloatingActionButton addButton;
    private ShareViewModel viewModel;
    private NoteListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        initView(view);

        recyclerView.setHasFixedSize(true);
        adapter = new NoteListAdapter(new NoteListAdapter.NoteDiff(), this);
        //    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            viewModel = new ViewModelProvider(requireActivity())
                    .get(ShareViewModel.class);

            viewModel.getAllNote().observe(getViewLifecycleOwner(), notes -> {
                adapter.submitList(notes);
            });
        }catch (Exception e){
            Log.e(TAG, "onViewCreated: ",e);
        }


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listFragment_to_addFragment);
            }
        });
    }

    private void initView(View view) {
        navController = NavHostFragment.findNavController(this);
        recyclerView = view.findViewById(R.id.recyclerview);
        addButton = view.findViewById(R.id.fab);
    }

    @Override
    public void onDeleteClick(View view, int position) {

        viewModel.delete(viewModel.getAllNote().getValue().get(position));
        adapter.notifyItemRemoved(position);
    }

}