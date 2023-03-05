package bkk.waytoeat.repository.youtube;

import bkk.waytoeat.domain.Youtube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YoutubeRepository extends JpaRepository<Youtube, Long>, YoutubeRepositoryCustom {
}
