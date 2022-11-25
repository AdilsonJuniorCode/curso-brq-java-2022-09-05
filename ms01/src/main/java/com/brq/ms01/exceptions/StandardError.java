package com.brq.ms01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    protected Date timestamp;
    protected Integer status;
    protected String error;
    protected String message;
    protected String path;


}