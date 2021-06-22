package com.etfbl.dimitric.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends HttpException {
    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED, (Object)null);
    }

    public UnauthorizedException(Object data) {
        super(HttpStatus.UNAUTHORIZED, data);
    }
}
