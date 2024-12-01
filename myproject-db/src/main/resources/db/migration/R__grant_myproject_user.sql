-- Grant local connections
grant select, insert, update, delete on actor to 'myproject'@'localhost';
grant select, insert, update, delete on address to 'myproject'@'localhost';
grant select on category to 'myproject'@'localhost';
grant select, insert, update on city to 'myproject'@'localhost';
grant select on country to 'myproject'@'localhost';
grant select, insert, update, delete on customer to 'myproject'@'localhost';
grant select, insert, update, delete on film to 'myproject'@'localhost';
grant select, insert, update, delete on film_actor to 'myproject'@'localhost';
grant select, insert, update, delete on film_category to 'myproject'@'localhost';
grant select, insert, update, delete on film_text to 'myproject'@'localhost';
grant select, insert, update, delete on inventory to 'myproject'@'localhost';
grant select on language to 'myproject'@'localhost';
grant select, insert, update, delete on payment to 'myproject'@'localhost';
grant select, insert, update, delete on rental to 'myproject'@'localhost';
grant select, insert, update, delete on staff to 'myproject'@'localhost';
grant select, insert, update, delete on store to 'myproject'@'localhost';

-- Grant remote connections
grant select, insert, update, delete on actor to 'myproject'@'%';
grant select, insert, update, delete on address to 'myproject'@'%';
grant select on category to 'myproject'@'%';
grant select, insert, update on city to 'myproject'@'%';
grant select on country to 'myproject'@'%';
grant select, insert, update, delete on customer to 'myproject'@'%';
grant select, insert, update, delete on film to 'myproject'@'%';
grant select, insert, update, delete on film_actor to 'myproject'@'%';
grant select, insert, update, delete on film_category to 'myproject'@'%';
grant select, insert, update, delete on film_text to 'myproject'@'%';
grant select, insert, update, delete on inventory to 'myproject'@'%';
grant select on language to 'myproject'@'%';
grant select, insert, update, delete on payment to 'myproject'@'%';
grant select, insert, update, delete on rental to 'myproject'@'%';
grant select, insert, update, delete on staff to 'myproject'@'%';
grant select, insert, update, delete on store to 'myproject'@'%';
