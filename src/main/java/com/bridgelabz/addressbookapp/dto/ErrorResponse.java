package com.bridgelabz.addressbookapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 *
 */
@Getter
@Setter
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
