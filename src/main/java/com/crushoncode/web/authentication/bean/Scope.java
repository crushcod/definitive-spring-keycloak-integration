package com.crushoncode.web.authentication.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scope {
    private String code;
    private List<HttpMethod> httpMethods;
}
