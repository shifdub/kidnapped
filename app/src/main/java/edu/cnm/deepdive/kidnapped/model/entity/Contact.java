package edu.cnm.deepdive.kidnapped.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * A Contact entity class that holds the data associated with a Contact including contactName, contactId,
 * phoneNumber, userId, and alertMessage.
 */

@Entity(foreignKeys = {
    @ForeignKey(
        entity = User.class, parentColumns = "user_id", childColumns = "user_id", onDelete = ForeignKey.CASCADE)
})

public class Contact {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "contact_id")
  private long contactId;

  @NonNull
  @ColumnInfo(name = "name")
  private String name;

  @NonNull
  @ColumnInfo(name = "phone_number")
  private String phoneNumber;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @NonNull
  @ColumnInfo(name = "alert_message")
  private String alertMessage;


  /**
   * Getter for contactId
   * @return returns a long id
   */

  public long getContactId() {
    return contactId;
  }

  /**
   * Setter for contactId
   * @return returns a long id
   */

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }

  /**
   * Getter for name
   * @return returns a String id
   */

  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Setter for userId
   * @return returns a string that represents the name
   */

  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Getter for phoneNumber
   * @return returns a String that represents the phoneNumber
   */

  @NonNull
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Setter for phoneNumber
   * @return returns a String that represents the phoneNumber
   */

  public void setPhoneNumber(@NonNull String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Getter for UserId
   * @return returns a long userId
   */

  public long getUserId() {
    return userId;
  }

  /**
   * Setter for UserId
   * @return returns a long userId
   */

  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Getter for getAlertMessage
   * @return returns a String that represents an AlertMessage
   */

  @NonNull
  public String getAlertMessage() {
    return alertMessage;
  }

  /**
   * Setter for getAlertMessage
   * @return returns a String that represents an AlertMessage
   */

  public void setAlertMessage(@NonNull String alertMessage) {
    this.alertMessage = alertMessage;
  }
}

