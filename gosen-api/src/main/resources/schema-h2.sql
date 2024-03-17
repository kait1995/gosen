CREATE TABLE control_panel_entity(
	setting_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	use_camera BOOLEAN,
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
CREATE TABLE device_status_entity(
    status_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    device_number INT UNIQUE NOT NULL,
    battery_status VARCHAR(255),
    signal_strength VARCHAR(255)
);
CREATE TABLE environmental_data_entity(
	data_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,	
	status_id BIGINT,
	data_type VARCHAR(255),
	data_value VARCHAR(255),
	date  VARCHAR(255),
	foreign key (status_id) references device_status_entity(status_id)
);