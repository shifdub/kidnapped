package edu.cnm.deepdive.kidnapped.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.kidnapped.model.dao.ContactDao;
import edu.cnm.deepdive.kidnapped.model.dao.UserDao;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import edu.cnm.deepdive.kidnapped.model.entity.User;


/**
 * A Database class that keeps track of user and contact and
 * build via data access object classes
 */

  @Database(
      entities = {User.class, Contact.class},
      version = 1, exportSchema = true)
  public abstract class KidnappedDatabase extends RoomDatabase {

      private static final String DB_NAME = "kidnapped_db";

      private static Application context;

  /**
   * Constructor for the database.
   * @param context , an application object which provides the context
   */

      public static void setContext(Application context) {
    KidnappedDatabase.context = context;
    }

  /**
   * Constructor that gets us the instance of the Database.
   */

    public static KidnappedDatabase getInstance() {
      return InstanceHolder.INSTANCE;
      }

  /**
   * Getter for UserDao
   * @return returns userDao
   */

  public abstract UserDao getUserDao();

  /**
   * Getter for contactDao
   * @return returns userDao
   */

  public abstract ContactDao getContactDao();

  /**
   * InstanceHolder method uses Room to build database for the app
   */
      private static class InstanceHolder {

        private static final KidnappedDatabase INSTANCE =
            Room.databaseBuilder(context, KidnappedDatabase.class, DB_NAME)
                .build();
      }


}
