package com.wahaha.heyworld.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Classes implements Serializable {
    private String className;
    private String description;
    private List<Methods> methodsList;
}
