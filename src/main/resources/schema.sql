-- CREATE TABLE IF NOT EXISTS movie (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    title VARCHAR(250) NOT NULL,
--    movieDescription VARCHAR(700) NOT NULL,
--    quality VARCHAR(50) NOT NULL,
--    genre VARCHAR(50) NOT NULL,
--    duration VARCHAR(250) NOT NULL,
--    releaseDate VARCHAR(250) NOT NULL,
--    poster VARCHAR(250) NOT NULL,
--    avrRating INT,
--    userIds VARCHAR(100),
--    viewCount INT
-- );
DROP TABLE IF EXISTS movie;

CREATE TABLE movie (
                       id INTEGER PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       movieDescription VARCHAR(2000),
                       quality VARCHAR(20),
                       genre VARCHAR(20),
                       duration VARCHAR(50),
                       releaseDate VARCHAR(50),
                       poster VARCHAR(255),
                       avrRating INTEGER,
                       userIds VARCHAR(255),
                       viewCount INTEGER
);
