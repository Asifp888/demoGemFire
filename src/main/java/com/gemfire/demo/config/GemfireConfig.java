package com.gemfire.demo.config;


import com.gemfire.demo.domain.User;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@EnableGemfireRepositories(basePackages = "com.gemfire.demo.repository")
@EnableEntityDefinedRegions(basePackages = "com.gemfire.demo.model")
public class GemfireConfig {

    @Bean(name = "gemfireCache")
    public ClientCache gemfireCache() {
        return new ClientCacheFactory()
                .addPoolLocator("locator", 10334)
                .create();
    }


    @Bean
    public org.apache.geode.cache.Region<String, User> usersRegion(ClientCache cache) {
        ClientRegionFactory<String, User> regionFactory =
                cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        return regionFactory.create("Users");
    }
}
