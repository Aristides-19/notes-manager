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

-- Customer per Type
SELECT
    CASE
        WHEN document LIKE 'J%' THEN 'juridical'
        ELSE 'natural'
    END as type,
    count(*) AS count
FROM customers
GROUP BY type;

-- Invoice/Note order by Date
SELECT *
FROM invoice_records
WHERE strftime('%d-%m-%Y', created_on, 'localtime') LIKE '18%'
ORDER BY date(created_on, 'localtime') DESC LIMIT 1;