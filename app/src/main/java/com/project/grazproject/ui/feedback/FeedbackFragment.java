package com.project.grazproject.ui.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentFeedbackBinding;

public class FeedbackFragment extends Fragment {

    private FragmentFeedbackBinding binding;
    TextView feedbackText, feedbackMessage;
    Button send;
    String address, subject;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FeedbackViewModel myMessagesViewModel =
                new ViewModelProvider(this).get(FeedbackViewModel.class);

        binding = FragmentFeedbackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        feedbackText = binding.textFeedback;

        send = binding.SendFeedback;
        feedbackMessage = binding.FeedBackMessage;

        //TODO: почта, на которую высывается письмо
        address = "ov.bakai@gmail.com";
        subject = "Сообщение от пользователя \"СознательныйГражданин\"";

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");

                // Кому
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {address});
                // Зачем
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                // О чём
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, feedbackMessage.getText().toString());

                FeedbackFragment.this.startActivity(Intent.createChooser(emailIntent,
                        "Отправка письма..."));

            }
        });

        myMessagesViewModel.getText().observe(getViewLifecycleOwner(), feedbackText::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}