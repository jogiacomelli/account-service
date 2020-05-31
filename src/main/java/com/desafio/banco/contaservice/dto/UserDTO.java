package com.desafio.banco.contaservice.dto;

import com.desafio.banco.contaservice.common.UserType;
import lombok.Data;

@Data
public class UserDTO {
    private Long document;
    private UserType type;
    private String name;
    private Integer score;
}
