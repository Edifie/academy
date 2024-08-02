CREATE TABLE
    T_TEAM (
        id BIGINT NOT NULL PRIMARY KEY,
        name text NOT NULL,
        product text NOT NULL,
        created_at timestamp DEFAULT now (),
        modified_at timestamp DEFAULT now (),
        default_location text,
        CHECK (default_location IN ('Porto', 'Lisbon', 'Braga'))
    );

CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;