package com.github.locust4j.http.generator;

import org.apache.http.client.methods.HttpUriRequest;

/**
 * @author myzhan
 * @date 2018/11/02
 */
public abstract class BaseRequestGenerator {

    /**
     * getRequest must be thread-safe!
     *
     * @return
     */
    public abstract HttpUriRequest getRequest();
}
