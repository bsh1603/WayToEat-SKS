package bkk.waytoeat.controller;

import bkk.waytoeat.dto.StoreNameAndLinkDto;
import bkk.waytoeat.repository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StoreController {

    @Autowired
    private final StoreRepository storeRepository;

    @GetMapping("/api/store/simple")
    public StoreNameAndLinkDto returnNameAndLinkApi(@RequestParam double latitude,
                                    @RequestParam double longitude) {
        Map<String, String> map = new HashMap<>();
        StoreNameAndLinkDto result = storeRepository.searchWithLatAndLong(latitude, longitude);

        return result;
    }
}
