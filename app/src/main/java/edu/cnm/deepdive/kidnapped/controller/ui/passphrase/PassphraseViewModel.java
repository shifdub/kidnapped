package edu.cnm.deepdive.kidnapped.controller.ui.passphrase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PassphraseViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public PassphraseViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("RECORD A PASSPHRASE");
  }

  public LiveData<String> getText() {
    return mText;
  }
}