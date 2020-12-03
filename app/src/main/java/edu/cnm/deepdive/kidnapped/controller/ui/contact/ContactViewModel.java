package edu.cnm.deepdive.kidnapped.controller.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public ContactViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("ADD A CONTACT");
  }

  public LiveData<String> getText() {
    return mText;
  }
}