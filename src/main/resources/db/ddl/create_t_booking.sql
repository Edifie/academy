CREATE TABLE
    T_BOOKING (
        rack_id BIGINT NOT NULL,
        requester_id BIGINT NOT NULL,
        book_from timestamp NOT NULL,
        book_to timestamp NOT NULL,
        created_at timestamp DEFAULT now (),
        modified_at timestamp DEFAULT now (),
        FOREIGN KEY (rack_id) REFERENCES T_RACK (id),
        FOREIGN KEY (requester_id) REFERENCES T_TEAM_MEMBER (id)
    );