package com.example.notepadjava.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.notepadjava.R;
import com.example.notepadjava.datamodel.Note;
import com.example.notepadjava.ui.ShareViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


public class AddFragment extends Fragment {

    private Button btnAdd;
    private EditText etTitle, etDesc;
    private ShareViewModel viewModel;
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        initView(view);

        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String desc = etDesc.getText().toString();

                Note note  = new Note(title,desc);

                viewModel.insert(note);

                navController.navigateUp();
            }
        });
    }

    private void initView(View view) {
        navController = NavHostFragment.findNavController(this);
        btnAdd = view.findViewById(R.id.btn_add);
        etDesc = view.findViewById(R.id.et_desc);
        etTitle = view.findViewById(R.id.et_title);

    }
}