package com.piyush;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.piyush")
public class Application {
  public static void main(String[] args) throws Exception {
    new SpringApplicationBuilder(Application.class).run(args);
  }
}
