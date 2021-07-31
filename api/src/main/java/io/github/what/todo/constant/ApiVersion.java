package io.github.what.todo.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiVersion {

    private static final String version = "v1";
    public static final String CURRENT_VERSION = "/api/" + version;
}
