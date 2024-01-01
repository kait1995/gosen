
CREATE TABLE item_setting_entity(
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
CREATE TABLE environmental_data_entity(
	data_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,	
	device_number INT,
	battery_status VARCHAR(255),
	signal_strength VARCHAR(255),
	humidity VARCHAR(255),
	temperature VARCHAR(255),
	option0 VARCHAR(255),
	option1 VARCHAR(255),
	option2 VARCHAR(255),
	option3 VARCHAR(255),
	option4 VARCHAR(255),
	option5 VARCHAR(255),
	option6 VARCHAR(255),
	option7 VARCHAR(255),
	option8 VARCHAR(255),
	option9 VARCHAR(255),
	date  VARCHAR(255)
);
