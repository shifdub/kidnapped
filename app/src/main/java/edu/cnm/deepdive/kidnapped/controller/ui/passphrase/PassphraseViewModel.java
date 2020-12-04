package edu.cnm.deepdive.kidnapped.controller.ui.passphrase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *  This viewModel is for the PassphraseFragment
 */

public class PassphraseViewModel extends ViewModel {


  /**
   * This method creates a new MutableLiveData with no value assigned to it
   */

  private MutableLiveData<String> mText;

  public PassphraseViewModel() {
    mText = new MutableLiveData<>();
  }

  /**
   * Getter for LiveData getText
   * @return returns a LiveData string of Text
   */

  public LiveData<String> getText() {
    return mText;
  }
}