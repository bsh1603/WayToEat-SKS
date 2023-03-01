package bkk.waytoeat.repository.store;

import bkk.waytoeat.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StoreRepository extends JpaRepository<Store, String>, StoreRepositoryCustom{
}
