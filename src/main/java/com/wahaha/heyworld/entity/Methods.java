package com.wahaha.heyworld.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Methods implements Serializable {
        private String methodName;
        private String path;
        private String description;
        private List<Fields> fieldList;
}
