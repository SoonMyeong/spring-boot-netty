package com.soon.netty.server;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NettyStartupTask implements ApplicationListener<ApplicationReadyEvent> {

    private final NettyServer nettyServer;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        nettyServer.start();
    }
}
