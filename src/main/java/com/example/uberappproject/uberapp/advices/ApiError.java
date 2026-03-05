package com.example.uberappproject.uberapp.advices;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;

    ApiError(HttpStatus status, String message, List<String> subErrors) {
        this.status = status;
        this.message = message;
        this.subErrors = subErrors;
    }

    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getSubErrors() {
        return this.subErrors;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSubErrors(List<String> subErrors) {
        this.subErrors = subErrors;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ApiError)) return false;
        final ApiError other = (ApiError) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$subErrors = this.getSubErrors();
        final Object other$subErrors = other.getSubErrors();
        if (this$subErrors == null ? other$subErrors != null : !this$subErrors.equals(other$subErrors)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ApiError;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $subErrors = this.getSubErrors();
        result = result * PRIME + ($subErrors == null ? 43 : $subErrors.hashCode());
        return result;
    }

    public String toString() {
        return "ApiError(status=" + this.getStatus() + ", message=" + this.getMessage() + ", subErrors=" + this.getSubErrors() + ")";
    }

    public static class ApiErrorBuilder {
        private HttpStatus status;
        private String message;
        private List<String> subErrors;

        ApiErrorBuilder() {
        }

        public ApiErrorBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder subErrors(List<String> subErrors) {
            this.subErrors = subErrors;
            return this;
        }

        public ApiError build() {
            return new ApiError(this.status, this.message, this.subErrors);
        }

        public String toString() {
            return "ApiError.ApiErrorBuilder(status=" + this.status + ", message=" + this.message + ", subErrors=" + this.subErrors + ")";
        }
    }
}
