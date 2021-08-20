CREATE TABLE blog_user
(
  id VARCHAR(100) NOT NULL,
  login VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  description VARCHAR(200) NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);