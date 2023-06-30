package com.gabrielag.flooringmastery1.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Gabriela Gutierrez
 */

public class AuditDaoFileImpl implements AuditDao {
    public static final String AUDIT_FILE = "Audit.txt";
    @Override
    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException("Could not persist audit information.", e);
        }

        LocalDateTime timeStamp = LocalDateTime.now();
        out.println(timeStamp.toString() + " : " + entry);
        out.flush();
    }
}
