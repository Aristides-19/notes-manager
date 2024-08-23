-- CLIENTS TABLE
CREATE TABLE IF NOT EXISTS customers
(
    customer_id    INTEGER PRIMARY KEY,
    full_name      TEXT NOT NULL,
    document       TEXT NOT NULL UNIQUE,
    contact        TEXT NOT NULL DEFAULT '',
    second_contact TEXT NOT NULL DEFAULT '',
    address        TEXT NOT NULL DEFAULT '',
    last_timestamp TEXT NOT NULL
);

-- INVOICES TABLE
CREATE TABLE IF NOT EXISTS invoice_records
(
    invoice_id  INTEGER PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    created_on  TEXT    NOT NULL,
    subtotal    REAL    NOT NULL,
    tax         REAL    NOT NULL,
    total       REAL    NOT NULL,
    status      INTEGER NOT NULL DEFAULT 0,
    comment     TEXT    NOT NULL DEFAULT '',
    FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id)
        ON DELETE CASCADE
);

-- NOTES TABLE
CREATE TABLE IF NOT EXISTS note_entries
(
    note_id     INTEGER PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    created_on  TEXT    NOT NULL,
    total       REAL    NOT NULL DEFAULT 0,
    status      INTEGER NOT NULL DEFAULT 0,
    comment     TEXT    NOT NULL DEFAULT '',
    FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id)
        ON DELETE CASCADE
);

-- INVOICE RECORD PRODUCTS TABLE
CREATE TABLE IF NOT EXISTS invoice_record_products
(
    product_id    INTEGER PRIMARY KEY,
    invoice_id    INTEGER NOT NULL,
    quantity      INTEGER NOT NULL DEFAULT 1,
    description   TEXT    NOT NULL,
    unit_price_bs REAL    NOT NULL DEFAULT 0,
    FOREIGN KEY (invoice_id)
        REFERENCES invoice_records (invoice_id)
        ON DELETE CASCADE
);

-- NOTE ENTRY PRODUCTS TABLE
CREATE TABLE IF NOT EXISTS note_entry_products
(
    product_id     INTEGER PRIMARY KEY,
    note_id        INTEGER NOT NULL,
    quantity       INTEGER NOT NULL DEFAULT 1,
    description    TEXT    NOT NULL,
    unit_price_usd REAL    NOT NULL DEFAULT 0,
    FOREIGN KEY (note_id)
        REFERENCES note_entries (note_id)
        ON DELETE CASCADE
);