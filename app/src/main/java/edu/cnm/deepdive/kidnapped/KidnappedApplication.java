package edu.cnm.deepdive.kidnapped;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.kidnapped.service.KidnappedDatabase;
import io.reactivex.schedulers.Schedulers;

public class KidnappedApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    KidnappedDatabase.setContext(this);
    KidnappedDatabase.getInstance().getContactDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
