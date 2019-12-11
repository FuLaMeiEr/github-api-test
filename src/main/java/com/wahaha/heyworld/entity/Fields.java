package com.wahaha.heyworld.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Fields implements Serializable {
    private String fieldName;
    private String type;
}
