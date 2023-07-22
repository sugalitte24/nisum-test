create table phones
(
    uuid             uuid(255) not null,
    created_at       timestamp,
    last_modified_at timestamp,
    city_code        bigint,
    country_code     bigint,
    number           bigint,
    primary key (uuid)
);
create table users
(
    uuid             uuid(255) not null,
    created_at       timestamp,
    last_modified_at timestamp,
    email            varchar(255),
    is_active        boolean,
    last_login       timestamp,
    name             varchar(255),
    password         varchar(255),
    primary key (uuid)
);
create table users_phones
(
    users_uuid  uuid(255) not null,
    phones_uuid uuid(255) not null
)