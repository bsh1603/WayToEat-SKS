package bkk.waytoeat.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.util.List;

// 이름, 좌표, 유튜브링크, id
@Data
public class StoreNameAndLinkDto {

    String name;

    String storeId;
    @Builder.Default
    List<String> youtubeLink;

    @QueryProjection
    public StoreNameAndLinkDto(String name, String storeId, List<String> youtubeLink) {
        this.name = name;
        this.storeId = storeId;
        this.youtubeLink = youtubeLink;
    }
}
