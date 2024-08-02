CREATE TABLE
    T_RACK_ASSET (
        id BIGINT NOT NULL PRIMARY KEY,
        asset_tag varchar(10) NOT NULL,
        rack_id BIGINT NOT NULL,
        FOREIGN KEY (rack_id) REFERENCES T_RACK (id)
    );

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ASSET_ID;