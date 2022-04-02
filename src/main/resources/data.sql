-- USERS

INSERT INTO Users (id, name)
VALUES (100, 'Tom');

INSERT INTO Users (id, name)
VALUES (101, 'Dick');

INSERT INTO Users (id, name)
VALUES (102, 'Harry');

-- REVIEWS

INSERT INTO Post (id, title, content, author_id)
VALUES (200, 'Open Mic Night', 'Open Mic & Karaoke night in the Student Lounge', 101);

INSERT INTO Post (id, title, content, author_id)
VALUES (201, 'Jobot is Hiring', 'Entry Level Engineering Manager Position', 101);

INSERT INTO Post (id, title, content, author_id)
VALUES (202, 'The New Pixel 6', 'The All New Pixel 6 is Here!', 102);
