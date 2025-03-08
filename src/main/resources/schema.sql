CREATE SCHEMA IF NOT EXISTS course;

CREATE TABLE IF NOT EXISTS course.partner
(
    id   UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255)     NOT NULL
);

CREATE TABLE IF NOT EXISTS course.client
(
    id   UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255)     NOT NULL
);

CREATE TABLE IF NOT EXISTS course.course_type
(
    id   UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255)     NOT NULL
);

CREATE TABLE IF NOT EXISTS course.course
(
    id             UUID PRIMARY KEY NOT NULL,
    created_at     TIMESTAMP        NOT NULL,
    starts_at      DATE             NOT NULL,
    ends_at        DATE             NOT NULL,
    client_id      UUID             NOT NULL,
    partner_id     UUID             NOT NULL,
    course_type_id UUID             NOT NULL,
    CONSTRAINT course_client FOREIGN KEY (client_id) REFERENCES course.client (id) ON DELETE CASCADE,
    CONSTRAINT course_partner FOREIGN KEY (partner_id) REFERENCES course.partner (id) ON DELETE CASCADE,
    CONSTRAINT course_course_type FOREIGN KEY (course_type_id) REFERENCES course.course_type (id) ON DELETE CASCADE
);
