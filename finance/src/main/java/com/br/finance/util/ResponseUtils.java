package com.br.finance.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseUtils {

    public HttpStatus created = HttpStatus.CREATED;
    public HttpStatus successful = HttpStatus.OK;
    public HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    public HttpStatus noContent = HttpStatus.NO_CONTENT;
    public HttpStatus internalError = HttpStatus.INTERNAL_SERVER_ERROR;
}
