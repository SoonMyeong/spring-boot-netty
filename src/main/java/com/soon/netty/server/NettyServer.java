package com.soon.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyServer {

    private final NettyProperties nettyProperties;
    private final NettyChannelInitializer nettyChannelInitializer;

    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(nettyProperties.getBossThreadCount());
        EventLoopGroup workerGroup = new NioEventLoopGroup(nettyProperties.getWorkerThreadCount());

        try {
            ServerBootstrap serverBootStrap = new ServerBootstrap();
            serverBootStrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(nettyChannelInitializer);

            ChannelFuture channelFuture = serverBootStrap.bind(nettyProperties.getPort()).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
