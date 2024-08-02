CREATE TABLE
    T_RACK (
        id BIGINT NOT NULL PRIMARY KEY,
        serial_number text NOT NULL,
        team_id BIGINT,
        default_location varchar(10),
        status varchar(20),
        modified_at timestamp DEFAULT now (),
        created_at timestamp DEFAULT now (),
        FOREIGN KEY (team_id) REFERENCES T_TEAM (id)
    );

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;