
create table members (
     id bigint not null auto_increment,
     login_id varchar(100) unique not null,
     nickname varchar(50) unique not null,
     password varchar(500) not null,
     user_type varchar(10) not null,
     input_id bigint not null,
     create_date date default sysdate() not null,
     update_id bigint not null,
     update_date date default sysdate() not null,
     primary key (id)

)