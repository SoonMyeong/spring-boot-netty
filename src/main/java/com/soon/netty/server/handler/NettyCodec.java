package com.soon.netty.server.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soon.netty.server.NettyProperties;
import com.soon.netty.server.dto.ClientRequestDto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class NettyCodec extends MessageToMessageCodec<ByteBuf, Object> {

    private final ObjectMapper objectMapper;
    private final NettyProperties nettyProperties;

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) throws Exception {

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        String message = msg.toString(StandardCharsets.UTF_8);
        ClientRequestDto clientRequestDto = objectMapper.readValue(message,ClientRequestDto.class);
        out.add(clientRequestDto);
    }
}
