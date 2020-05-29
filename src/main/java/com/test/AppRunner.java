package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

  @Autowired
  public AppRunner() {

  }

  @Override
  public void run(String... args) {
    Doner doner = new Doner.Builder(Doner.EkmekTuruType.SOMUN, Doner.EtTuruType.DANA)
        .setYesillik(false).setTursu(false).setSogan(true)
        .build();
    System.out.println(doner.toString());
  }

}
