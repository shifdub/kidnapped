package edu.cnm.deepdive.kidnapped.controller.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * This holds the ViewModel for the HomeFragment shown to the User.
 *
 */

public class HomeViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  /**
   * This method creates a new MutableLiveData with no value assigned to it
   */
  public HomeViewModel() {
    mText = new MutableLiveData<>();
  }

  /**
   * Getter  for LiveData getText
   * @return returns a LiveData string of Text
   */
  public LiveData<String> getText() {
    return mText;
  }
}