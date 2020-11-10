package edu.cnm.deepdive.kidnapped.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity ( foreignKeys = {
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

  @NonNull
  @ColumnInfo(name = "user_id")
  private User userId;

  @NonNull
  @ColumnInfo(name = "alert_message" )
  private String alertMessage;

  public long getContactId() {
    return contactId;
  }

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(@NonNull String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @NonNull
  public User getUserId() {
    return userId;
  }

  public void setUserId(@NonNull User userId) {
    this.userId = userId;
  }

    @NonNull
  public String getAlertMessage() {
    return alertMessage;
  }

  public void setAlertMessage(@NonNull String alertMessage) {
    this.alertMessage = alertMessage;
  }
}

