create table t_user(
                       id_user bigserial PRIMARY KEY,
                       fio varchar(200) unique ,
                       date_of_birth varchar(10) NOT NULL,
                       library_card_number bigserial unique
);

create table Book(
                     isbn bigserial PRIMARY KEY ,
                     name varchar(1000) not null ,
                     all_authors varchar(200) not null ,
                     year varchar(4) not null ,
                     amount_of_pages int not null
);

create table Issurance(
                          id_issurance bigserial primary key,
                          card_number_of_user bigserial not null references t_user(library_card_number),
                          isbn_of_book bigserial not null references Book(isbn),
                          date_of_issurance varchar(10) not null ,
                          period_of_usage varchar(10) not null
);