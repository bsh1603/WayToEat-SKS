package bkk.waytoeat.repository.store;

import bkk.waytoeat.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, String>, StoreRepositoryCustom{
}
