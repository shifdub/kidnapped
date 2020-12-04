package edu.cnm.deepdive.kidnapped.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.kidnapped.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;


@Dao
public interface UserDao {

  /**
   *
   * @param user allows us to save, update, and delete single, multiple or all users
   * @return returns user data for single , multiple or all users
   */
  @Insert
  Single<Long> insert (User user);

  @Insert
  Single<List<Long>> insert (User... users);

  @Insert
  Single<List<Long>> insert (Collection<User> users);

  @Update
  Single<Integer> update (User user);

  @Update
  Single<Integer> update (User... users);

  @Update
  Single<Integer> update (Collection<User> users);

  @Delete
  Single<Integer> delete (User user);

  @Delete
  Single<Integer> delete (User... users);

  @Delete
  Single<Integer> delete (Collection<User> users);

  /**
   *
   * @param id Selects current user
   * @return returns current user from query
   */

  @Query("SELECT * FROM User WHERE user_id = :id ")
  LiveData<User>getCurrentUser(long id);

  /**
   *
   * @return returns all users from query
   */
  @Query("SELECT * FROM User")
  LiveData<List<User>>getAllUser();


}
