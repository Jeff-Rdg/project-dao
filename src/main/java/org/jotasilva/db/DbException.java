package org.jotasilva.db;

public class DbException extends RuntimeException{
    private static final long serivalVersionUID = 1L;

    public DbException(String message){
        super(message);
    }
}
