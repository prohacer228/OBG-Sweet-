package com.project.grazproject.ui.sections;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SectionsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SectionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Тут будут рубрики");
    }

    public LiveData<String> getText() {
        return mText;
    }
}