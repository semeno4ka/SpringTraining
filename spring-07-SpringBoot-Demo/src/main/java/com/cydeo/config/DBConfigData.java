package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.List;
@Configuration
@ConfigurationProperties(prefix = "db")//"server"
@Data
public class DBConfigData {

    private String username;
    private String password;
    private List<String> type;// because there are more than one listed in db.type (oracle, postgres,amazon)
}
