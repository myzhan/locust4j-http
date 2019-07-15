package com.github.locust4j.http;

import com.github.locust4j.http.config.GlobalConfiguration;
import com.github.locust4j.http.generator.RandomPostGenerator;
import com.github.locust4j.http.task.HttpTaskBuilder;
import com.github.myzhan.locust4j.Locust;

/**
 * @author myzhan
 */
public class Main {

    public static void main(String[] args) {
        try {
            GlobalConfiguration.init(args);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to initialize GlobalConfiguration, will exit now.");
            System.exit(1);
        }

        Locust locust = Locust.getInstance();
        locust.setMasterHost(GlobalConfiguration.getMasterHost());
        locust.setMasterPort(GlobalConfiguration.getMasterPort());

        if (GlobalConfiguration.getMaxRPS() > 0) {
            // enable max RPS control
            locust.setMaxRPS(GlobalConfiguration.getMaxRPS());
        }

        HttpTaskBuilder builder = new HttpTaskBuilder();
        builder.setWeight(10)
            .setName("http")
            .setRequestGenerator(new RandomPostGenerator());
        locust.run(builder.build());
    }
}
