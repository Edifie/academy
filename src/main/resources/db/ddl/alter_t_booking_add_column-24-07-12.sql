ALTER TABLE T_BOOKING
ADD COLUMN id BIGINT NOT NULL PRIMARY KEY;

CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;