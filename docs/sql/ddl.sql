CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_name`  TEXT,
    `passphrase` TEXT
);

CREATE TABLE IF NOT EXISTS `Contact`
(
    `contact_id`    INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`          TEXT                              NOT NULL,
    `phone_number`  TEXT                              NOT NULL,
    `user_id`       INTEGER                           NOT NULL,
    `alert_message` TEXT                              NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Contact_user_id` ON `Contact` (`user_id`);
