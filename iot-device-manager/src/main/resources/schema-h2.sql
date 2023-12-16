
CREATE TABLE graph_data_entity(
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
