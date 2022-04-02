-- USERS

INSERT INTO Users (id, user_name)
VALUES (100, 'Tom') ON CONFLICT DO NOTHING ;

INSERT INTO Users (id, user_name)
VALUES (101, 'Dick') ON CONFLICT DO NOTHING ;

INSERT INTO Users (id, user_name)
VALUES (102, 'Harry') ON CONFLICT DO NOTHING ;

-- POSTS

INSERT INTO Posts (id, title, content, author_id)
VALUES (200, 'Open Mic Night', 'Open Mic & Karaoke night in the Student Lounge', 101)
ON CONFLICT DO NOTHING ;

INSERT INTO Posts (id, title, content, author_id)
VALUES (201, 'Jobot is Hiring', 'Entry Level Engineering Manager Position', 101)
ON CONFLICT DO NOTHING ;

INSERT INTO Posts (id, title, content, author_id)
VALUES (202, 'The New Pixel 6', 'The All New Pixel 6 is Here!', 102)
ON CONFLICT DO NOTHING ;
