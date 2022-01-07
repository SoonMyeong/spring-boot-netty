package com.soon.netty.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClientRequestDto {
    private String id;
    private String name;
}
