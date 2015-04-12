package com.azdes.connect;

/**
 * Thrown while trying to connect to a third-party photo service. Typically wraps a more specific exception.
 * @author sbrougher
 */
public class ConnectionException extends RuntimeException {
    private static final long serialVersionUID = 2711916260904494322L;
    
    public ConnectionException(String msg, Exception e) {
        super(msg, e);
    }
}
