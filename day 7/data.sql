
TRUNCATE TABLE patient RESTART IDENTITY CASCADE;


INSERT INTO patient (name, email, gender, birthdate, blood_group)
VALUES
  ('Aryan Kamble', 'aryan.kamble@example.com', 'MALE', '2003-07-15', 'O_POSITIVE'),
  ('Sneha Patil', 'sneha.patil@example.com', 'FEMALE', '2002-11-22', 'A_POSITIVE'),
  ('Rahul Sharma', 'rahul.sharma@example.com', 'MALE', '2001-05-30', 'B_NEGATIVE'),
  ('Pooja Deshmukh', 'pooja.deshmukh@example.com', 'FEMALE', '2000-09-18', 'AB_POSITIVE'),
  ('Amit Verma', 'amit.verma@example.com', 'MALE', '1999-01-12', 'O_NEGATIVE');
