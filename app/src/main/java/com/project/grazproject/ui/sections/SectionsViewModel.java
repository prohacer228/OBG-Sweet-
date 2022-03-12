package com.project.grazproject.ui.sections;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.project.grazproject.databinding.FragmentSectionsBinding;


import com.project.grazproject.mapsactivity.MapsActivity;

public class SectionsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private FragmentSectionsBinding binding;
    TextView sectionParkingLink;

    public SectionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");

    }

    public LiveData<String> getText() {
        return mText;
    }


}