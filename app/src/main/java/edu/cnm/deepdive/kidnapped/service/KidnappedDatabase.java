package edu.cnm.deepdive.kidnapped.service;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.kidnapped.model.entity.Contact;
import edu.cnm.deepdive.kidnapped.model.entity.User;

public class KidnappedDatabase {
  @Database(
      entities = {User.class, Contact.class};

  @TypeConverters({User.class, Contact.class})
  public abstract class KidnappedDatabase extends RoomDatabase {





      public static KidnappedDatabase getInstance() {
      return InstanceHolder.INSTANCE;
      }

      public abstract UserDao getUserDao();

      public abstract ContactDao getMatchDao();

}
