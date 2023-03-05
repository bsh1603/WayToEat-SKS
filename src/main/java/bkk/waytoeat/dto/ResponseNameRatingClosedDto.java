package bkk.waytoeat.dto;

import lombok.Data;

@Data
public class ResponseNameRatingClosedDto {

    private String name;
    private double naverRating;
    private double kakaoRating;
    private double selfRating;
    private String closed;

    public ResponseNameRatingClosedDto(String name, double naverRating, double kakaoRating, double selfRating, String closed) {
        this.name = name;
        this.naverRating = naverRating;
        this.kakaoRating = kakaoRating;
        this.selfRating = selfRating;
        this.closed = closed;
    }
}
