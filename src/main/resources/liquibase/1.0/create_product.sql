create table products
(
    id           serial
        primary key,
    propertyname varchar not null,
    price        numeric,
    currency     varchar,
    image        text,
    locationname varchar not null,
    beds         varchar not null,
    baths        varchar not null
);