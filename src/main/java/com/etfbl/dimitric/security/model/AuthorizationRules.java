package com.etfbl.dimitric.security.model;

import lombok.Data;

import java.util.List;

@Data
public class AuthorizationRules {
    private List<Rule> rules;
}
