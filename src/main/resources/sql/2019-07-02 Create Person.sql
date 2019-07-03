
create  table  Person(
  id bigserial  primary key,
 fisrt_name varchar (50),
 second_name varchar (50),
 last_name varchar (50),
 address_ref int , foreign key (address_ref) references address(id)
)
select from Person;

drop table person;


alter table Person
add column uppdate_date DATE;