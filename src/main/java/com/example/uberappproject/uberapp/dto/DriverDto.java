package com.example.uberappproject.uberapp.dto;

public class DriverDto {

    private UserDto user;
    private Double rating;

    public DriverDto(UserDto user, Double rating) {
        this.user = user;
        this.rating = rating;
    }

    public DriverDto() {
    }

    public UserDto getUser() {
        return this.user;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DriverDto)) return false;
        final DriverDto other = (DriverDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$rating = this.getRating();
        final Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DriverDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        return result;
    }

    public String toString() {
        return "DriverDto(user=" + this.getUser() + ", rating=" + this.getRating() + ")";
    }
}
