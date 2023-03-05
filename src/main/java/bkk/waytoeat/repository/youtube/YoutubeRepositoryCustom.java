package bkk.waytoeat.repository.youtube;

import bkk.waytoeat.dto.ResponseNameToIdsDto;

import java.util.List;

public interface YoutubeRepositoryCustom {

    List<ResponseNameToIdsDto> getIds(String name);
}
