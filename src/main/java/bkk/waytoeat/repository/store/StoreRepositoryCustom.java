package bkk.waytoeat.repository.store;

import bkk.waytoeat.dto.ResponseNameRatingClosedDto;
import bkk.waytoeat.dto.ResponseStoreDetailDto;
import bkk.waytoeat.dto.StoreNameAndLinkDto;

import java.util.List;

public interface StoreRepositoryCustom {
    List<StoreNameAndLinkDto> searchWithLatAndLong(double latitude, double longitude);

    ResponseNameRatingClosedDto infoCardSearchWithId(String id);

    ResponseStoreDetailDto getStoreDetail(String id);
}
