package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

  private final GitHubLookupService gitHubLookupService;

  public AppRunner(GitHubLookupService gitHubLookupService) {
    logger.info("constractor begin");
    this.gitHubLookupService = gitHubLookupService;
    logger.info("constractor end");
  }

  @Override
  public void run(String... args) throws Exception {
    // Start the clock
    long start = System.currentTimeMillis();

    // Kick of multiple, asynchronous lookups

    logger.info("kicks starts");
    CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
    logger.info("kick 1 end");
    CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
    logger.info("kick 2 end");
    CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
    logger.info("kicks ends");
    logger.info("other codes goes to their own head.");
    // Wait until they are all done
    Thread.sleep(10000);
//    CompletableFuture.allOf(page1,page2,page3).join();
    logger.info("other codes worked.");

    // Print results, including elapsed time
    logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
    logger.info("--> " + page1.get());
    logger.info("--> " + page2.get());
    logger.info("--> " + page3.get());

  }

}