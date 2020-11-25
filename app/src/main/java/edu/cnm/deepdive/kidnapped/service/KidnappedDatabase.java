package edu.cnm.deepdive.kidnapped.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.kidnapped.model.dao.ContactDao;
import edu.cnm.deepdive.kidnapped.model.dao.UserDao;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import edu.cnm.deepdive.kidnapped.model.entity.User;



  @Database(
      entities = {User.class, Contact.class},
      version = 1, exportSchema = true)
  public abstract class KidnappedDatabase extends RoomDatabase {

      private static final String DB_NAME = "kidnapped_db";

      private static Application context;

      public static void setContext(Application context) {
    KidnappedDatabase.context = context;
    }

    public static KidnappedDatabase getInstance() {
      return InstanceHolder.INSTANCE;
      }

      public abstract UserDao getUserDao();

      public abstract ContactDao getContactDao();

      private static class InstanceHolder {

        private static final KidnappedDatabase INSTANCE =
            Room.databaseBuilder(context, KidnappedDatabase.class, DB_NAME)
                .build();
      }


}
