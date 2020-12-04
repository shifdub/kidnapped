package edu.cnm.deepdive.kidnapped.controller.ui.contact;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import edu.cnm.deepdive.kidnapped.service.ContactRepository;
import io.reactivex.disposables.CompositeDisposable;

/**
 *  This viewModel is for the ContactFragment
 */

public class ContactViewModel extends AndroidViewModel {

  private final ContactRepository contactRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  /**
   *
   * @param application This is base class for maintaining the state of the contactRepository
   */

  public ContactViewModel(
      @NonNull Application application) {
    super(application);
    contactRepository = new ContactRepository(application);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  /**
   * The save method is for saving contacts in the contactRepository
   * @param contact instance of Contact entity class that holds data associated with a contact
   */

  public void save(Contact contact) {
    throwable.setValue(null);
    pending.add(
        contactRepository.save(contact)
            .subscribe(
                () -> {},
                throwable::postValue
            )
    );
  }
}