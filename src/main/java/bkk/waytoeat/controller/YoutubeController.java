package bkk.waytoeat.controller;

import bkk.waytoeat.dto.ResponseNameToIdsDto;
import bkk.waytoeat.repository.youtube.YoutubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class YoutubeController {

    @Autowired
    YoutubeRepository youtubeRepository;

    @GetMapping("/api/youtube/name/ids")
    public List<ResponseNameToIdsDto> responseNameToIdsApi(@RequestParam String name) {
        List<ResponseNameToIdsDto> result = youtubeRepository.getIds(name);
        return result;
    }
}
