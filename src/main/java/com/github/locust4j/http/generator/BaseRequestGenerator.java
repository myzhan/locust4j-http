package com.github.locust4j.http.generator;

import org.apache.http.client.methods.HttpUriRequest;

/**
 * @author myzhan
 */
public abstract class BaseRequestGenerator {

    /**
     * getRequest must be thread-safe!
     *
     */
    public abstract HttpUriRequest getRequest();
}
