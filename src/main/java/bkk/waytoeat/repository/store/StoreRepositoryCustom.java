package bkk.waytoeat.repository.store;

import bkk.waytoeat.dto.StoreNameAndLinkDto;

import java.util.List;

public interface StoreRepositoryCustom {
    List<StoreNameAndLinkDto> searchWithLatAndLong(double latitude, double longitude);
}
