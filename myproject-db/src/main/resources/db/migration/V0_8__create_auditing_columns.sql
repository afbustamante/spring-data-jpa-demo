-- actor
alter table actor add column created_at timestamp;
alter table actor add column created_by varchar(16);
alter table actor add column modified_by varchar(16);

update actor set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table actor modify column created_at timestamp not null;
alter table actor modify column created_by varchar(16) not null;
alter table actor modify column modified_by varchar(16) not null;

-- address
alter table address add column created_at timestamp;
alter table address add column created_by varchar(16);
alter table address add column modified_by varchar(16);

update address set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table address modify column created_at timestamp not null;
alter table address modify column created_by varchar(16) not null;
alter table address modify column modified_by varchar(16) not null;

-- category
alter table category add column created_at timestamp;
alter table category add column created_by varchar(16);
alter table category add column modified_by varchar(16);

update category set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table category modify column created_at timestamp not null;
alter table category modify column created_by varchar(16) not null;
alter table category modify column modified_by varchar(16) not null;

-- city
alter table city add column created_at timestamp;
alter table city add column created_by varchar(16);
alter table city add column modified_by varchar(16);

update city set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table city modify column created_at timestamp not null;
alter table city modify column created_by varchar(16) not null;
alter table city modify column modified_by varchar(16) not null;

-- country
alter table country add column created_at timestamp;
alter table country add column created_by varchar(16);
alter table country add column modified_by varchar(16);

update country set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table country modify column created_at timestamp not null;
alter table country modify column created_by varchar(16) not null;
alter table country modify column modified_by varchar(16) not null;

-- customer
alter table customer rename column create_date to created_at;
alter table customer add column created_by varchar(16);
alter table customer add column modified_by varchar(16);

update customer set created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table customer modify column created_at timestamp not null;
alter table customer modify column created_by varchar(16) not null;
alter table customer modify column modified_by varchar(16) not null;

-- film
alter table film add column created_at timestamp;
alter table film add column created_by varchar(16);
alter table film add column modified_by varchar(16);

update film set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table film modify column created_at timestamp not null;
alter table film modify column created_by varchar(16) not null;
alter table film modify column modified_by varchar(16) not null;

-- film_actor
alter table film_actor add column created_at timestamp;
alter table film_actor add column created_by varchar(16);
alter table film_actor add column modified_by varchar(16);

update film_actor set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table film_actor modify column created_at timestamp not null;
alter table film_actor modify column created_by varchar(16) not null;
alter table film_actor modify column modified_by varchar(16) not null;

-- film_category
alter table film_category add column created_at timestamp;
alter table film_category add column created_by varchar(16);
alter table film_category add column modified_by varchar(16);

update film_category set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table film_category modify column created_at timestamp not null;
alter table film_category modify column created_by varchar(16) not null;
alter table film_category modify column modified_by varchar(16) not null;

-- inventory
alter table inventory add column created_at timestamp;
alter table inventory add column created_by varchar(16);
alter table inventory add column modified_by varchar(16);

update inventory set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table inventory modify column created_at timestamp not null;
alter table inventory modify column created_by varchar(16) not null;
alter table inventory modify column modified_by varchar(16) not null;

-- language
alter table language add column created_at timestamp;
alter table language add column created_by varchar(16);
alter table language add column modified_by varchar(16);

update language set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table language modify column created_at timestamp not null;
alter table language modify column created_by varchar(16) not null;
alter table language modify column modified_by varchar(16) not null;

-- payment
alter table payment add column created_at timestamp;
alter table payment add column created_by varchar(16);
alter table payment add column modified_by varchar(16);

update payment set created_at = payment_date, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table payment modify column created_at timestamp not null;
alter table payment modify column created_by varchar(16) not null;
alter table payment modify column modified_by varchar(16) not null;

-- rental
alter table rental add column created_at timestamp;
alter table rental add column created_by varchar(16);
alter table rental add column modified_by varchar(16);

update rental set created_at = rental_date, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table rental modify column created_at timestamp not null;
alter table rental modify column created_by varchar(16) not null;
alter table rental modify column modified_by varchar(16) not null;

-- staff
alter table staff add column created_at timestamp;
alter table staff add column created_by varchar(16);
alter table staff add column modified_by varchar(16);

update staff set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table staff modify column created_at timestamp not null;
alter table staff modify column created_by varchar(16) not null;
alter table staff modify column modified_by varchar(16) not null;

-- store
alter table store add column created_at timestamp;
alter table store add column created_by varchar(16);
alter table store add column modified_by varchar(16);

update store set created_at = last_update, created_by = 'SYSTEM', modified_by = 'SYSTEM';

alter table store modify column created_at timestamp not null;
alter table store modify column created_by varchar(16) not null;
alter table store modify column modified_by varchar(16) not null;
