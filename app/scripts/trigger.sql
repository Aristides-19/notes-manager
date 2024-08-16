-- VIRTUAL TABLE INSERT
CREATE TRIGGER tri_ins AFTER INSERT ON customers BEGIN
    INSERT INTO trigram_customers(ROWID, full_name, document) VALUES (new.customer_id, new.full_name, new.document);
END;

-- VIRTUAL TABLE DELETE
CREATE TRIGGER tri_del AFTER DELETE ON customers BEGIN
    INSERT INTO trigram_customers(trigram_customers, ROWID, full_name, document) VALUES ('delete', old.customer_id, old.full_name, old.document);
END;

-- VIRTUAL TABLE UPDATE
CREATE TRIGGER tri_upd AFTER UPDATE ON customers BEGIN
    INSERT INTO trigram_customers(trigram_customers, ROWID, full_name, document) VALUES ('delete', old.customer_id, old.full_name, old.document);
    INSERT INTO trigram_customers(ROWID, full_name, document) VALUES (new.customer_id, new.full_name, new.document);
END;