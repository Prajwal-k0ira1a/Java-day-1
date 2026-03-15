-- -- Create and Use Database
-- CREATE DATABASE IF NOT EXISTS learning_logs;
-- USE learning_logs;
--
-- -- Drop existing tables for a clean install
-- DROP TABLE IF EXISTS topics;
--
-- -- Topics table
-- CREATE TABLE topics (
--                         id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
--                         name VARCHAR(100) NOT NULL,
--                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
-- );
-- 
-- DROP TABLE IF EXISTS entries;
--
-- -- Entries table
# CREATE TABLE entries (
#                         id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
#                         topic_id INT(11) NOT NULL,
#                         note TEXT NOT NULL,
#                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#                         FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE
# );
USE learning_logs;
select * from Topics;
