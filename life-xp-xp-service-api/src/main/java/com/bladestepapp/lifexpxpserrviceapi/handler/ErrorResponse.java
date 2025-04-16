package com.bladestepapp.lifexpxpserrviceapi.handler;

import lombok.Value;

@Value
public class ErrorResponse {

    String errorCode;
    String message;
    String details;
}