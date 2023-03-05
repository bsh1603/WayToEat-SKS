package bkk.waytoeat.controller;

import bkk.waytoeat.dto.ResponseNameRatingClosedDto;
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

    @GetMapping("/api/store/simple")
    public List<StoreNameAndLinkDto> returnNameAndLinkApi(@RequestParam double latitude,
                                    @RequestParam double longitude) {
        List<StoreNameAndLinkDto> result = storeRepository.searchWithLatAndLong(latitude, longitude);
        return result;
    }

    @GetMapping("/api/store/info")
    public ResponseNameRatingClosedDto responseNameRatingClosedDto(
            @RequestParam String id) {
        ResponseNameRatingClosedDto result = storeRepository.infoCardSearchWithId(id);
        return result;
    }

}
