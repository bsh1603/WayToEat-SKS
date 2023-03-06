package bkk.waytoeat.controller;

import bkk.waytoeat.dto.ResponseNameRatingClosedDto;
import bkk.waytoeat.dto.ResponseStoreDetailDto;
import bkk.waytoeat.dto.StoreNameAndLinkDto;
import bkk.waytoeat.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {

    @Autowired
    private final StoreRepository storeRepository;

    // 좌표를 통해 가게 이름, 해당 유튜브 링크 반환
    @GetMapping("/api/store/simple")
    public List<StoreNameAndLinkDto> returnNameAndLinkApi(@RequestParam double latitude,
                                    @RequestParam double longitude) {
        List<StoreNameAndLinkDto> result = storeRepository.searchWithLatAndLong(latitude, longitude);
        return result;
    }

    // id를 통해 가게 인포카드 반환
    @GetMapping("/api/store/info")
    public ResponseNameRatingClosedDto responseNameRatingClosedDto(
            @RequestParam String id) {
        ResponseNameRatingClosedDto result = storeRepository.infoCardSearchWithId(id);
        return result;
    }

    // id를 통해 가게 상세정보 반환
    @GetMapping("/api/store/detail")
    public ResponseStoreDetailDto responseStoreDetailDto(
            @RequestParam String id) {
        ResponseStoreDetailDto result = storeRepository.getStoreDetail(id);
        return result;
    }

}
