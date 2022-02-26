package com.project.grazproject.ui.myMessages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentMyMessagesBinding;

public class MyMessagesFragment extends Fragment {

    private FragmentMyMessagesBinding binding;
    TextView myMessagesText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyMessagesViewModel myMessagesViewModel =
                new ViewModelProvider(this).get(MyMessagesViewModel.class);

        binding = FragmentMyMessagesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        myMessagesText = binding.textMyMessages;
        myMessagesViewModel.getText().observe(getViewLifecycleOwner(), myMessagesText::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}