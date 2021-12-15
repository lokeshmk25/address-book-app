package com.bridgelabz.addressbookapp.entity;

import lombok.Data;
/**
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 *
 */
@Data
public class ResponseEntity {
    private String message;
    private Object data;
    private Object status;

    public ResponseEntity(String message,Object data, Object status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }
}
