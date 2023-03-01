package bkk.waytoeat.dto;

import lombok.Data;

// 이름, 좌표, 유튜브링크, id
@Data
public class StoreNameAndLinkDto {

    String name;
    String id;

    public StoreNameAndLinkDto(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
