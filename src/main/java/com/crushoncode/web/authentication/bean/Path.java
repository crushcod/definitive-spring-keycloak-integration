package com.crushoncode.web.authentication.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Path {
    private String code;
    private String pattern;
    private Map<Role, List<Scope>> roleMap;
}
