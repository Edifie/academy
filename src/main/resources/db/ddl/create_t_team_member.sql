CREATE TABLE
    T_TEAM_MEMBER (
        id BIGINT NOT NULL PRIMARY KEY,
        team_id BIGINT,
        ctw_id varchar(7) NOT NULL,
        CHECK (ctw_id ILIKE ('CTW%')),
        name varchar(30) NOT NULL,
        created_at timestamp DEFAULT now (),
        modified_at timestamp DEFAULT now (),
        FOREIGN KEY (team_id) REFERENCES T_TEAM (id)
    );

CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_MEMBER_ID;