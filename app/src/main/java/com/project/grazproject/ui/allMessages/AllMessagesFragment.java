package com.project.grazproject.ui.allMessages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentAllMessagesBinding;

public class AllMessagesFragment extends Fragment {

    private FragmentAllMessagesBinding binding;
    TextView allMessagesText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AllMessagesViewModel allMessagesViewModel =
                new ViewModelProvider(this).get(AllMessagesViewModel.class);

        binding = FragmentAllMessagesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        allMessagesText = binding.textAllMessages;
        allMessagesViewModel.getText().observe(getViewLifecycleOwner(), allMessagesText::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}