package edu.cnm.deepdive.kidnapped.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.kidnapped.model.dao.ContactDao;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import io.reactivex.Completable;
import java.util.List;

/**
 * Repository class that implemented by the contactDao
 */

public class ContactRepository {

  private final Context context;
  private final ContactDao contactDao;

  /**
   * @param context gives access to contactDao
   */

  public ContactRepository(Context context) {
    this.context = context;
    contactDao = KidnappedDatabase.getInstance().getContactDao();
  }

  /**
   * @param contact assigns an id for a Contact in contactDao
   * @return returns info saved by user
   */

  public Completable save(Contact contact) {
    return (contact.getContactId() == 0)
        ? contactDao.insert(contact)
        .doAfterSuccess(contact::setContactId)
        .ignoreElement()
        : contactDao.update(contact)
            .ignoreElement();
  }


  /**

   * @param contact allows user id to be deleted from contactDao
   * @return
   */

  public Completable delete(Contact contact) {
    return (contact.getContactId() == 0)
        ? Completable.complete()
        : contactDao.delete(contact)
            .ignoreElement();
  }

  /**
   *
   * LiveData getter for getCurrentContact
   * @return returns a CurrentContact
   */

  public LiveData<Contact> getCurrentContact(Contact contact) {
    return contactDao.getCurrentContact(contact.getContactId());
  }
  /**
   * LiveData getter for getAllUser
   * @return returns all Users
   */

  public LiveData<List<Contact>> getAll(Contact contact) {
    return contactDao.getAllContact();
  }

  /**
   * LiveData getter for getByName
   * @return returns a contact by name
   */

  public LiveData<Contact> getByName(Contact name) {
    return contactDao.getByName(name.getName());

  }

}