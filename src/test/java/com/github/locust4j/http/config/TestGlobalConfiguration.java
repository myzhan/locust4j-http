package com.github.locust4j.http.config;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author myzhan
 */
public class TestGlobalConfiguration {

    @Test
    public void TestParseArgument() throws Exception {
        List<String> args = new ArrayList<String>();
        args.add("-masterHost");
        args.add("192.168.1.1");
        args.add("-masterPort");
        args.add("10000");
        args.add("-maxRPS");
        args.add("200");
        args.add("-testURL");
        args.add("localhost:8080");

        GlobalConfiguration.init(args.toArray(new String[0]));

        assertEquals(GlobalConfiguration.getMasterHost(), "192.168.1.1");
        assertEquals(GlobalConfiguration.getMasterPort(), 10000);
        assertEquals(GlobalConfiguration.getMaxRPS(), 200);
        assertEquals(GlobalConfiguration.getTestURL(), "localhost:8080");
    }
}
