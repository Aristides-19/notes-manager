-- If a query is less than 3 chars, it must use LIKE with original table

-- It uses trigram to select every customer where their document starts with V-3
-- It can be used for substring of at least 3 chars
SELECT *
FROM customers
WHERE customer_id IN
    (SELECT ROWID
        FROM trigram_customers
        WHERE document MATCH '"V-3"'); -- Must be escaped because of special chars

-- Pattern Matching with names
SELECT *
FROM customers
WHERE customer_id IN
    (SELECT ROWID
        FROM trigram_customers
        WHERE full_name MATCH 'ris');