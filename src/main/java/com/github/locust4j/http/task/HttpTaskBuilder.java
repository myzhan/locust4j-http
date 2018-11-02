package com.github.locust4j.http.task;

import com.github.locust4j.http.generator.BaseRequestGenerator;

/**
 * @author myzhan
 * @date 2018/11/02
 */
public class HttpTaskBuilder {

    private HttpTask httpTask;

    public HttpTaskBuilder() {
        httpTask = new HttpTask();
    }

    public HttpTaskBuilder setWeight(int weight) {
        this.httpTask.setWeight(weight);
        return this;
    }

    public HttpTaskBuilder setName(String name) {
        this.httpTask.setName(name);
        return this;
    }

    public HttpTaskBuilder setRequestGenerator(BaseRequestGenerator requestGenerator) {
        this.httpTask.setRequestGenerator(requestGenerator);
        return this;
    }

    public HttpTask build() {
        return this.httpTask;
    }
}
