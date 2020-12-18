CREATE DATABASE product_catalog
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;



create table catalog
(
    id serial not null
        constraint catalog_pk
            primary key,
    catalog_name varchar(255) not null,
    catalog_description text not null
);