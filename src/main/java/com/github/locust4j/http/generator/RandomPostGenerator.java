package com.github.locust4j.http.generator;

import java.util.UUID;

import com.github.locust4j.http.config.GlobalConfiguration;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

/**
 * @author myzhan
 */
public class RandomPostGenerator extends BaseRequestGenerator {

    /**
     * Return a http post request, with a random uuid string in the body.
     * It's thread-safe.
     *
     */
    @Override
    public HttpUriRequest getRequest() {
        String uuid = UUID.randomUUID().toString();
        HttpPost request = new HttpPost(GlobalConfiguration.getTestURL());
        HttpEntity entity = new ByteArrayEntity(uuid.getBytes());
        request.setEntity(entity);
        return request;
    }
}
