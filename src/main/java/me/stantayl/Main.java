package me.stantayl;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().testing();
    }

    public void testing() {
        System.out.println("Working directory: " + System.getProperty("user.dir"));
//        testResource("me/stantayl/stan.conf");
//        System.out.println("config.resource=" + System.getProperty("config.resource"));

        Config conf = ConfigFactory.load();

        int bar1 = conf.getInt("foo.bar");
        System.out.println("bar1=" + bar1);

        Config foo = conf.getConfig("foo");
        System.out.println("foo=" + foo);

        int bar2 = foo.getInt("bar");
        System.out.println("bar2=" + bar2);
    }

    public void testResource(String path) {
        ClassLoader cl = getClass().getClassLoader();
        URL r = cl.getResource("me/stantayl/stan.conf");
        try {
            Path p = Paths.get(r.toURI());
            List<String> lines = Files.readAllLines(p);
            System.out.println("Contents of " + path);
            lines.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
