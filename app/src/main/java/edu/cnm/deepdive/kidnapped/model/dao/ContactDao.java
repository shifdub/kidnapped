package edu.cnm.deepdive.kidnapped.model.dao;

import android.provider.ContactsContract.Contacts;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ContactDao {

  @Insert
  Single<Long> insert (Contact contact);

  @Insert
  Single<List<Long>> insert (Contact... contacts);

  @Insert
  Single<List<Long>> insert (Collection<Contact> contacts);

  @Update
  Single<Integer> update (Contact contact);

  @Update
  Single<Integer> update (Contact... contacts);

  @Update
  Single<Integer> update (Collection<Contact> contacts);

  @Delete
  Single<Integer> delete (Contact contact);

  @Delete
  Single<Integer> delete (Contacts... contacts);

  @Delete
  Single<Integer> delete (Collection<Contact> contacts);

  @Query("SELECT * FROM Contact WHERE contact_id = :id ")
  LiveData<Contact> getCurrentContact(long id);

  @Query("SELECT * FROM Contact")
  LiveData<List<Contact>>getAllContact();

  @Query("SELECT * FROM Contact WHERE name = :name")
  LiveData<Contact>getByName(String name);
}

