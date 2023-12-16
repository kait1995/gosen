
CREATE TABLE device_setting_entity(
	setting_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(255),
	device_number INT,
	is_activated BOOLEAN,
	use_camera BOOLEAN,
	use_timer BOOLEAN,
	timer_start VARCHAR(255),
	timer_end VARCHAR(255),
	manual_watering BOOLEAN,
	status0 BOOLEAN,
	status1 BOOLEAN,
	status2 BOOLEAN,
	status3 BOOLEAN,
	status4 BOOLEAN,
	status5 BOOLEAN,
	status6 BOOLEAN,
	status7 BOOLEAN,
	status8 BOOLEAN,
	status9 BOOLEAN
);
CREATE TABLE user_account_entity(
	account_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE SEQUENCE DEVICE_SETTING_SEQ START WITH 1 INCREMENT BY 1;