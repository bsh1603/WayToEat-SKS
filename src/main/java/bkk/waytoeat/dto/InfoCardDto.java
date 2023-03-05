package bkk.waytoeat.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class InfoCardDto {

    private String name;
    @Builder.Default
    private List<String> storeId;
    private double naverRating;
    private double kakaoRating;
    private double selfRating;
    private String closed;

    @QueryProjection
    public InfoCardDto(String name, List<String> storeId, double naverRating, double kakaoRating, double selfRating, String closed) {
        this.name = name;
        this.storeId = storeId;
        this.naverRating = naverRating;
        this.kakaoRating = kakaoRating;
        this.selfRating = selfRating;
        this.closed = closed;
    }
}
