create table person 
    (ID INT GENERATED ALWAYS AS IDENTITY NOT NULL, name varchar(128) NOT NULL, last_name varchar(128) NOT NULL,
	 PRIMARY KEY (ID));
