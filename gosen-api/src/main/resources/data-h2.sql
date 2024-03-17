INSERT INTO control_panel_entity(setting_id,use_camera,manual_watering,status0,status1,status2,status3,status4,status5,status6,status7,status8,status9)
VALUES (0,true,true,true,true,true,true,true,true,true,true,true,true);

INSERT INTO device_status_entity(status_id,device_number,battery_status,signal_strength)
VALUES (0,1011,0.1,0.1);

INSERT INTO device_status_entity(status_id,device_number,battery_status,signal_strength)
VALUES (1,1012,0.2,0.2);

INSERT INTO device_status_entity(status_id,device_number,battery_status,signal_strength)
VALUES (2,1013,0.3,0.3);

INSERT INTO device_status_entity(status_id,device_number,battery_status,signal_strength)
VALUES (3,1014,0.4,0.4);

INSERT INTO device_status_entity(status_id,device_number,battery_status,signal_strength)
VALUES (4,1015,0.5,0.5);

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (0,0,'temperature','20','2020-01-01');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (1,0,'humidity','21','2020-01-02');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (2,0,'temperature','22','2020-01-03');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (3,0,'humidity','23','2020-01-04');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (4,1,'temperature','24','2020-01-05');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (5,1,'temperature','24','2020-01-05');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (6,1,'temperature','23','2020-01-06');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (7,1,'temperature','22','2020-01-07');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (8,1,'temperature','21','2020-01-08');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (9,1,'temperature','21','2020-01-08');

INSERT INTO environmental_data_entity(data_id,status_id,data_type,data_value,date)
VALUES (10,1,'temperature','23','2020-01-08');