package bkk.waytoeat.repository.store;

import bkk.waytoeat.dto.StoreNameAndLinkDto;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StoreRepositoryCustom {
    StoreNameAndLinkDto searchWithLatAndLong(double latitude, double longitude);
}
