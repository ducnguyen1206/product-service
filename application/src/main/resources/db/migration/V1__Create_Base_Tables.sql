CREATE TABLE IF NOT EXISTS tbl_product(
    id bigserial NOT NULL PRIMARY KEY,
    product_name varchar(255),
    price NUMERIC(7,5),
    category_id int8,
    default_quantity int4,
    description varchar(255),
    created_date timestamp,
    created_by varchar(255),
    last_updated_date timestamp,
    last_updated_by varchar(255)
);