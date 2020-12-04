package edu.cnm.deepdive.kidnapped.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.kidnapped.model.dao.UserDao;
import edu.cnm.deepdive.kidnapped.model.entity.User;
import io.reactivex.Completable;
import java.util.List;

/**
 * Repository class that implemented by the userDao
 */

public class UserRepository {

  private final Context context;
  private final UserDao userDao;

  /**
   * @param context gives access to userDao
   */

  public UserRepository(Context context) {
    this.context = context;
    userDao = KidnappedDatabase.getInstance().getUserDao();
  }

  /**
   * @param user assigns an id for a User in userDao
   * @return returns info saved by user
   */

  public Completable save(User user) {
    return (user.getId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement();
  }

  /**
   * @param user allows user id to be deleted from userDao
   * @return
   */

  public Completable delete(User user) {
    return (user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement();
  }

  /**
   * LiveData getter for getCurrentUser
   * @return returns a CurrentUser
   */

  public LiveData<User> getCurrentUser(User user) {
    return userDao.getCurrentUser(user.getId());
  }

  /**
   * LiveData getter for getAllUser
   * @return returns all Users
   */

  public LiveData<List<User>> getAll(User user) {
    return userDao.getAllUser();

  }
}