CREATE TABLE wallets (
    id UUID PRIMARY KEY ,
    user_id UUID NOT NULL UNIQUE ,
    balance NUMERIC(19,2) NOT NULL ,
    currency varchar(3) NOT NULL ,
    status VARCHAR(20) NOT NULL ,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);