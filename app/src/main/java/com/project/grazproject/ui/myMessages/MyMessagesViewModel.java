package com.project.grazproject.ui.myMessages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMessagesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MyMessagesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}