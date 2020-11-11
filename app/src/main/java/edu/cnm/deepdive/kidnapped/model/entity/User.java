package edu.cnm.deepdive.kidnapped.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(name = "user_name")
  private String userName;

  @ColumnInfo(name = "passphrase")
  private String passphrase;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase;
  }
}
