package bkk.waytoeat.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseNameToIdsDto {

    String id;
    String thumbnail;

    public ResponseNameToIdsDto(String id, String thumbnail) {
        this.id = id;
        this.thumbnail = thumbnail;
    }
}
