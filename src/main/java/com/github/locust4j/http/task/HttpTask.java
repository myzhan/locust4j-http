package com.github.locust4j.http.task;

import com.github.locust4j.http.client.HttpClientSingleton;
import com.github.locust4j.http.generator.BaseRequestGenerator;
import com.github.myzhan.locust4j.AbstractTask;
import com.github.myzhan.locust4j.Locust;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @author myzhan
 * @date 2018/11/02
 */
public class HttpTask extends AbstractTask {

    private int weight = 10;
    private String name = "http";

    private CloseableHttpClient httpClient;
    private BaseRequestGenerator requestGenerator;

    protected HttpTask() {
        httpClient = HttpClientSingleton.getInstance();
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequestGenerator(BaseRequestGenerator requestGenerator) {
        this.requestGenerator = requestGenerator;
    }

    @Override
    public void execute() {
        long startTime = System.currentTimeMillis();
        try {
            HttpUriRequest request = this.requestGenerator.getRequest();
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity responseEntity = response.getEntity();
            long contentLength = responseEntity.getContentLength();
            EntityUtils.consume(responseEntity);
            long elapsed = System.currentTimeMillis() - startTime;
            Locust.getInstance().recordSuccess("http", "success", elapsed, contentLength);
        } catch (Exception ex) {
            ex.printStackTrace();
            long elapsed = System.currentTimeMillis() - startTime;
            Locust.getInstance().recordFailure("http", "unknown", elapsed, ex.getMessage());
        }
    }
}
