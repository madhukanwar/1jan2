package com.example.MysqlAndLanbdaAndError;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AddDatabase  implements CommandLineRunner {

    @Autowired
    public AgencyDao ad;

    @Override
    public void run(String... args) throws Exception {
        log.info("preloading", ad.save(new Agency(101L,"Microsoft","america")));
        log.info("preloading", ad.save(new Agency(102L,"Window","Gate")));
    }
}
