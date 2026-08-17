CREATE TABLE transactions(
    id UUID PRIMARY KEY,
    wallet_id UUID NOT NULL ,
    amount NUMERIC(19,2) NOT NULL ,
    type VARCHAR(30) NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP with TIME ZONE NOT NULL
);
CREATE INDEX idx_transactions_wallet_id ON transactions(wallet_id);

CREATE TABLE ledger_entries(
    id UUID PRIMARY KEY,
    wallet_id UUID NOT NULL,
    transaction_id UUID NOT NULL,
    type VARCHAR(20) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    balance_after NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);
CREATE INDEX idx_ledger_entries_wallet_id ON ledger_entries(wallet_id);
CREATE INDEX idx_ledger_entries_transcation_id ON ledger_entries(transaction_id);