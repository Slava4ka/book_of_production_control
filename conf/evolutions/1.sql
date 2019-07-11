# product, journal schema

# --- !Ups

create table if not exists product
(
    id          bigint(20)   not null auto_increment,
    name        varchar(255) not null,
    description text(65535)  not NULL,
    ingredients text(65535)  not NULL,
    cost        int(10)      not null,
    price       int(10)      not null,
    created     datetime  default current_timestamp,
    deleted     datetime  default null,
    updated     timestamp default current_timestamp on update current_timestamp,
    primary key (id)
);


create table if not exists journal
(
    id         bigint(20) not null auto_increment,
    product_id bigint(20),
    quantity   bigint(20) not null,
    created    datetime  default current_timestamp,
    deleted    datetime  default null,
    updated    timestamp default current_timestamp on update current_timestamp,
    constraint fk_journal_product_id foreign key (product_id) references product(id)
        on delete set null
        on update restrict,
    primary key (id)
);


# --- !Downs

drop table if exists product;
drop table if exists journal;