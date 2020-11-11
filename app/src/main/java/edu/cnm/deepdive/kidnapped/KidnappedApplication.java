package edu.cnm.deepdive.kidnapped;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.kidnapped.service.KidnappedDatabase;

public class KidnappedApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    KidnappedDatabase.setContext(this);
  }
}
