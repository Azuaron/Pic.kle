package com.azdes.connect;

/**
 * Interface for connecting to third-party photo services.
 * @author sbrougher
 * @param <R>
 */
public interface IConnect<R> {
    /**
     * Connect, and return, the service.
     * @return
     * @throws ConnectionException
     */
    public R connect() throws ConnectionException;
}
