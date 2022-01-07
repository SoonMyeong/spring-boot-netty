package com.soon.netty.server;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "netty.server")
public class NettyProperties {
    private int port;
    private int bossThreadCount;
    private int workerThreadCount;
}
