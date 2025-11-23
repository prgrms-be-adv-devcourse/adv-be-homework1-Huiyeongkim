package com.example.homework.order2.entity;

import lombok.Data;

@Data
public class ResponseEntity<T> {
    private int status;
    private T data;
    private long count;

    public ResponseEntity(int value, T all, long count) {
        this.status = value;
        this.data = all;
        this.count = count;
    }
}