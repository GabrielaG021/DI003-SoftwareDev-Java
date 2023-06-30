package com.gabrielag.flooringmastery1.dao;

/**
 *
 * @author Gabriela Gutierrez
 */

public interface AuditDao {
    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException;
}
