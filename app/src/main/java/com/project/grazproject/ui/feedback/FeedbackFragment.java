package com.project.grazproject.ui.feedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentFeedbackBinding;

public class FeedbackFragment extends Fragment {

    private FragmentFeedbackBinding binding;
    TextView feedbackText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FeedbackViewModel myMessagesViewModel =
                new ViewModelProvider(this).get(FeedbackViewModel.class);

        binding = FragmentFeedbackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        feedbackText = binding.textFeedback;
        myMessagesViewModel.getText().observe(getViewLifecycleOwner(), feedbackText::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}