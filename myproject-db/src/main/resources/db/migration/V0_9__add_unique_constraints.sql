alter table category add constraint uc_category_name unique (name);

alter table city add constraint uc_city_country unique (country_id, city);

alter table country add constraint uc_country_name unique (country);

alter table customer add constraint uc_customer_email unique (email);

alter table film add constraint uc_film_title_year unique (title, release_year, length);

alter table language add constraint uc_language_name unique (name);

alter table staff add constraint uc_staff_email unique (email);
alter table staff add constraint uc_staff_username unique (username);
