package com.project.library.response;

import lombok.Getter;

@Getter
public class SingleResponse<T> {
    private T data;

    public SingleResponse(T data) {
        this.data = data;
    }
}
