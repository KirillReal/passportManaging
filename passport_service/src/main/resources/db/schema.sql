create table passports (
                           id serial primary key not null,
                           name varchar(2000) not null,
                           second_name varchar(2000) not null,
                           sex varchar(2000) not null,
                           birthday date not null,
                           expire date not null,
                           series varchar(2000) not null,
                           number varchar(2000) not null
);