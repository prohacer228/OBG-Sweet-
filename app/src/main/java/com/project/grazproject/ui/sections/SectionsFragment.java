package com.project.grazproject.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentSectionsBinding;
import com.project.grazproject.mapsactivity.MapsActivity;
import com.project.grazproject.register.RegisterActivity;
import com.project.grazproject.ui.CreateMessages.CreateMessage;
import com.project.grazproject.ui.login.LoginActivity;

public class SectionsFragment extends Fragment {

    private FragmentSectionsBinding binding;
    TextView sectionsText;
    TextView sectionParkingLink, sectionExpiredProducts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SectionsViewModel sectionsViewModel =
                new ViewModelProvider(this).get(SectionsViewModel.class);

        binding = FragmentSectionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        sectionsText = binding.textSections;
        sectionsViewModel.getText().observe(getViewLifecycleOwner(), sectionsText::setText);

        //Ссылки перехода на activity карт с фрагментов
       sectionParkingLink = binding.sectionParking;
        sectionExpiredProducts =binding.sectionExpiredProducts;

        sectionParkingLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*TODO: Здесь заменить переход на карты. На картах сделать кнопку "Дальше", по
                   которой уже будут осуществляться дальнейшие действия (создание сообщения)
                 */
                //Здесь пока переход сразу на создание сообщения CreateMessage
                Intent intent = new Intent(SectionsFragment.this.getActivity(), CreateMessage.class);
                startActivity(intent);
            }
        });

        //TODO: Здесь также поменять переход на карты
        sectionExpiredProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SectionsFragment.this.getActivity(), CreateMessage.class);
                startActivity(intent);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}