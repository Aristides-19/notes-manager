-- INDEX FOR MOST RECENT CUSTOMER
CREATE INDEX IF NOT EXISTS idx_customers_last_timestamp
    ON customers (datetime(last_timestamp));

-- INDEX FOR DOCUMENT AND FULL_NAME SUBSTRING QUERIES
CREATE VIRTUAL TABLE IF NOT EXISTS trigram_customers USING fts5(
    full_name,
    document,
    content='',
    tokenize='trigram case_sensitive 0 remove_diacritics 1'
);