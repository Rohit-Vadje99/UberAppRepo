package com.example.uberappproject.uberapp.services.impl;

import com.example.uberappproject.uberapp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    private static final String OSRM_API_BASE_URL = "http://router.project-osrm.org/route/v1/driving/";

    @Override
    public double calculateDistance(Point src, Point dest) {

        try {
            String uri = src.getX()+","+src.getY()+";"+dest.getX()+","+dest.getY();
            OSRMResponseDto responseDto = RestClient.builder()
                    .baseUrl(OSRM_API_BASE_URL)
                    .build()
                    .get()
                    .uri(uri)
                    .retrieve()
                    .body(OSRMResponseDto.class);

            return responseDto.getRoutes().get(0).getDistance()/1000.0;
        }catch (Exception e) {
            throw new RuntimeException("error getting data from OSRM "+e.getMessage());

        }
    }
}


class OSRMResponseDto {
    private List<OSRMRoute> routes;

    public OSRMResponseDto() {
    }

    public List<OSRMRoute> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<OSRMRoute> routes) {
        this.routes = routes;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OSRMResponseDto)) return false;
        final OSRMResponseDto other = (OSRMResponseDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$routes = this.getRoutes();
        final Object other$routes = other.getRoutes();
        if (this$routes == null ? other$routes != null : !this$routes.equals(other$routes)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OSRMResponseDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $routes = this.getRoutes();
        result = result * PRIME + ($routes == null ? 43 : $routes.hashCode());
        return result;
    }

    public String toString() {
        return "OSRMResponseDto(routes=" + this.getRoutes() + ")";
    }
}

class OSRMRoute {
    private Double distance;

    public OSRMRoute() {
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OSRMRoute)) return false;
        final OSRMRoute other = (OSRMRoute) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$distance = this.getDistance();
        final Object other$distance = other.getDistance();
        if (this$distance == null ? other$distance != null : !this$distance.equals(other$distance)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OSRMRoute;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $distance = this.getDistance();
        result = result * PRIME + ($distance == null ? 43 : $distance.hashCode());
        return result;
    }

    public String toString() {
        return "OSRMRoute(distance=" + this.getDistance() + ")";
    }
}