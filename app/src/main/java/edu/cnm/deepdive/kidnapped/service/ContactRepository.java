package edu.cnm.deepdive.kidnapped.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.kidnapped.model.dao.ContactDao;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import io.reactivex.Completable;
import java.util.List;


public class ContactRepository {

  private final Context context;
  private final ContactDao contactDao;


  public ContactRepository(Context context) {
    this.context = context;
    contactDao = KidnappedDatabase.getInstance().getContactDao();
  }

  public Completable save(Contact contact) {
    return (contact.getContactId() == 0)
        ? contactDao.insert(contact)
        .doAfterSuccess(contact::setContactId)
        .ignoreElement()
        : contactDao.update(contact)
            .ignoreElement();
  }

  public Completable delete(Contact contact) {
    return (contact.getContactId() == 0)
        ? Completable.complete()
        : contactDao.delete(contact)
            .ignoreElement();
  }

  public LiveData<Contact> getCurrentContact(Contact contact) {
    return contactDao.getCurrentContact(contact.getContactId());
  }

  public LiveData<List<Contact>> getAll(Contact contact) {
    return contactDao.getAllContact();
  }

  public LiveData<Contact> getByName(Contact name) {
    return contactDao.getByName(name.getName());

  }

}