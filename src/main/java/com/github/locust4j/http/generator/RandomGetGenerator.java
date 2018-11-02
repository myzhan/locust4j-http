package com.github.locust4j.http.generator;

import java.util.UUID;

import com.github.locust4j.http.config.GlobalConfiguration;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * @author myzhan
 * @date 2018/11/02
 */
public class RandomGetGenerator extends BaseRequestGenerator {

    @Override
    public HttpUriRequest getRequest() {
        String uuid = UUID.randomUUID().toString();
        HttpGet request = new HttpGet(GlobalConfiguration.getTestURL() + uuid);
        return request;
    }
}
