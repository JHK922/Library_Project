package com.project.library.response;

import lombok.Getter;

import java.util.List;

@Getter
public class MultiResponse<T> {
    private List<T> data;

    public MultiResponse(List<T> data) {
        this.data = data;
    }
}
