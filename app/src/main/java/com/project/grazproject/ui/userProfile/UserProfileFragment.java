package com.project.grazproject.ui.userProfile;

import static com.project.grazproject.User.User.RegUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.project.grazproject.databinding.FragmentUserProfileBinding;

public class UserProfileFragment extends Fragment {

    private FragmentUserProfileBinding binding;
    TextView profileText;
    EditText username, name, surname, middleName, city, street, house, apartment, email, password, phone;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserProfileViewModel sectionsViewModel =
                new ViewModelProvider(this).get(UserProfileViewModel.class);

        binding = FragmentUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        username = binding.profileUsername;
        name = binding.profileName;
        surname = binding.profileSurname;
        middleName = binding.profileMiddleName;
        city = binding.profileTown;
        street = binding.profileStreet;
        house = binding.profileHouse;
        apartment = binding.profileApart;
        email = binding.profileEmail;
        password = binding.profilePassword;
        phone = binding.profilePhoneNumber;


        setUserProfile();

        profileText = binding.textUserProfile;
        sectionsViewModel.getText().observe(getViewLifecycleOwner(), profileText::setText);

        return root;
    }

    void setUserProfile()
    {
        username.setText(RegUser.username);
        email.setText(RegUser.email);
        password.setText(RegUser.password);
        name.setText(RegUser.name);
        surname.setText(RegUser.surname);
        middleName.setText(RegUser.middleName);
        city.setText(RegUser.city);
        street.setText(RegUser.street);
        house.setText(RegUser.house);
        apartment.setText(RegUser.apartment);
        phone.setText(RegUser.phone);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //TODO: добавить возможность изменять данные и сохранять их в бд
}