package com.project.grazproject.ui.sections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentSectionsBinding;

public class SectionsFragment extends Fragment {

    private FragmentSectionsBinding binding;
    TextView sectionsText;

    /*
    TODO:  узнать, как лучше сделать боковую панель: в качестве выезжающего меню или создание
      нового окна
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SectionsViewModel sectionsViewModel =
                new ViewModelProvider(this).get(SectionsViewModel.class);

        binding = FragmentSectionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sectionsText = binding.textSections;
        sectionsViewModel.getText().observe(getViewLifecycleOwner(), sectionsText::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}