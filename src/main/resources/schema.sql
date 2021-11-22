DROP TABLE IF EXISTS NOTICE;

create table NOTICE
(
    ID       BIGINT auto_increment primary key,
    TITLE    varchar(255),
    CONTENTS varchar(255),

    HITS     integer,
    LIKES    integer,

    REG_DATE timestamp,
    UPDATE_DATE timestamp
)