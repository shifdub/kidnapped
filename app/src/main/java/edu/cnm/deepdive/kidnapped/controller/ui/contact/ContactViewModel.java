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

public class ContactViewModel extends AndroidViewModel {

  private final ContactRepository contactRepository;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public ContactViewModel(
      @NonNull Application application) {
    super(application);
    contactRepository = new ContactRepository(application);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

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