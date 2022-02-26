package com.project.grazproject.ui.allMessages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllMessagesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AllMessagesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Тут будут все сообщения");
    }

    public LiveData<String> getText() {
        return mText;
    }
}