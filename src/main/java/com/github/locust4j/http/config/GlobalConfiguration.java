package com.github.locust4j.http.config;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

/**
 * @author myzhan
 */
public class GlobalConfiguration {

    /**
     * Locust master host, defaults to 127.0.0.1.
     */
    private static String masterHost = "127.0.0.1";

    /**
     * Locust master port, defaults to 5557.
     */
    private static int masterPort = 5557;

    /**
     * Max RPS that Locust4j can generate.
     */
    private static int maxRPS = -1;

    /**
     * Test URL like http://127.0.0.1:8080/
     */
    private static String testURL;

    private static boolean initialized = false;

    public synchronized static void init(String[] args) throws Exception {

        if (initialized) {
            throw new Exception("GlobalConfiguration had been initialized, don't do it again.");
        }

        Options options = new Options();
        options.addOption("masterHost", true, "Locust master host, defaults to 127.0.0.1");
        options.addOption("masterPort", true, "Locust master port, defaults to 5557");
        options.addOption("maxRPS", true, "Max RPS that can generate, disabled by default");
        options.addOption("testURL", true, "Test URL like http://127.0.0.1:8080/");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args, false);

        if (cmd.hasOption("masterHost")) {
            GlobalConfiguration.setMasterHost(cmd.getOptionValue("masterHost"));
        }
        if (cmd.hasOption("masterPort")) {
            GlobalConfiguration.setMasterPort(Integer.valueOf(cmd.getOptionValue("masterPort")));
        }
        if (cmd.hasOption("maxRPS")) {
            GlobalConfiguration.setMaxRPS(Integer.valueOf(cmd.getOptionValue("maxRPS")));
        }
        if (cmd.hasOption("testURL")) {
            GlobalConfiguration.setTestURL(cmd.getOptionValue("testURL"));
        }

        GlobalConfiguration.initialized = true;
    }

    public static String getMasterHost() {
        return masterHost;
    }

    public static void setMasterHost(String masterHost) {
        GlobalConfiguration.masterHost = masterHost;
    }

    public static int getMasterPort() {
        return masterPort;
    }

    public static void setMasterPort(int masterPort) {
        GlobalConfiguration.masterPort = masterPort;
    }

    public static int getMaxRPS() {
        return maxRPS;
    }

    public static void setMaxRPS(int maxRPS) {
        GlobalConfiguration.maxRPS = maxRPS;
    }

    public static String getTestURL() {
        return testURL;
    }

    public static void setTestURL(String testURL) {
        GlobalConfiguration.testURL = testURL;
    }
}
