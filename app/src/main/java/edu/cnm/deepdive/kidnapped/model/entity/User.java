package edu.cnm.deepdive.kidnapped.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A User entity class that holds the data associated with a User including userName, UserId,
 * and the users passphrase.
 */

@Entity
public class User {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(name = "user_name")
  private String userName;

  @ColumnInfo(name = "passphrase")
  private String passphrase;

  /**
   * Getter for userId
   * @return returns a long id
   */

  public long getId() {
    return id;
  }

  /**
   * Setter for userId
   * @return returns a long id
   */

  public void setId(long id) {
    this.id = id;
  }

  /**
   * Getter for UserName
   * @return returns a String that represent the UserName
   */

  public String getUserName() {
    return userName;
  }

  /**
   * Setter for UserName
   * @return returns a String that represent the UserName
   */

  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * Getter for passphrase
   * @return returns a String that represents the passphrase.
   */

  public String getPassphrase() {
    return passphrase;
  }

  /**
   * Setter for passphrase
   * @return returns a String that represents the passphrase.
   */

  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase;
  }
}
