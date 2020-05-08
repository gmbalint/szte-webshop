DROP DATABASE IF EXISTS webshop;
CREATE DATABASE webshop;
USE webshop;

create table dbo.products
(
    id       bigint not null
        primary key,
    name     varchar(255),
    price    float  not null,
    quantity int    not null
);

create table dbo.users
(
    id            bigint not null
        primary key,
    credit        float  not null,
    first_name    varchar(255),
    last_name     varchar(255),
    password_hash varchar(255),
    user_name     varchar(255)
);

create table dbo.orders
(
    id         bigint not null
        primary key,
    order_time datetime2,
    status     int,
    user_id    bigint
        constraint FK32ql8ubntj5uh44ph9659tiih
            references users
);

create table dbo.order_item
(
    id         bigint not null
        primary key,
    price      float  not null,
    quantity   int    not null,
    order_id   bigint
        constraint FKt4dc2r9nbvbujrljv3e23iibt
            references orders,
    product_id bigint
        constraint FKc5uhmwioq5kscilyuchp4w49o
            references products
);

create table dbo.orders_items
(
    order_id bigint not null
        constraint FKij1wwgx6o198ubsx1oulpopem
            references orders,
    items_id bigint not null
        constraint UK_7qrg5pfgjon82yhgwfqrdijm5
            unique
        constraint FKl3w3fx5rbjq0tbb2i0xidwabh
            references order_item
);


