package com.example.uberappproject.uberapp.advices;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public T getData() {
        return this.data;
    }

    public ApiError getError() {
        return this.error;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ApiResponse)) return false;
        final ApiResponse<?> other = (ApiResponse<?>) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$timeStamp = this.getTimeStamp();
        final Object other$timeStamp = other.getTimeStamp();
        if (this$timeStamp == null ? other$timeStamp != null : !this$timeStamp.equals(other$timeStamp)) return false;
        final Object this$data = this.getData();
        final Object other$data = other.getData();
        if (this$data == null ? other$data != null : !this$data.equals(other$data)) return false;
        final Object this$error = this.getError();
        final Object other$error = other.getError();
        if (this$error == null ? other$error != null : !this$error.equals(other$error)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ApiResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $timeStamp = this.getTimeStamp();
        result = result * PRIME + ($timeStamp == null ? 43 : $timeStamp.hashCode());
        final Object $data = this.getData();
        result = result * PRIME + ($data == null ? 43 : $data.hashCode());
        final Object $error = this.getError();
        result = result * PRIME + ($error == null ? 43 : $error.hashCode());
        return result;
    }

    public String toString() {
        return "ApiResponse(timeStamp=" + this.getTimeStamp() + ", data=" + this.getData() + ", error=" + this.getError() + ")";
    }
}
