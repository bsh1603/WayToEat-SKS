package bkk.waytoeat.dto;

import lombok.Data;

@Data
public class StoreLocationParam {

    double latitude;
    double longitude;

    public StoreLocationParam(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
