CREATE TABLE users (

                       id UUID PRIMARY KEY,

                       full_name VARCHAR(100) NOT NULL,

                       email VARCHAR(255) UNIQUE NOT NULL,

                       password_hash VARCHAR(255) NOT NULL,

                       role VARCHAR(30) NOT NULL,

                       status VARCHAR(30) NOT NULL,

                       created_at TIMESTAMP NOT NULL

);