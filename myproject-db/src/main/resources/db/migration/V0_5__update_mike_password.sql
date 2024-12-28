-- Change existing SHA-1 password to BCRYPT password for Mike
update staff set password = '$2a$12$9RLKZ79qn7fs./zWD2U/8.7mwYvdPpFXwZ8sCeUaYlM7tGaBhAKKe' where username = 'Mike';
