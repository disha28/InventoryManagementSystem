package IMS.com.InventoryManagementSystem.Repository;

import IMS.com.InventoryManagementSystem.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT i FROM Item i " +
            "JOIN i.product p " +
            "JOIN i.category c " +
            "JOIN i.vendor v " +
            "JOIN i.shelf s " +
            "WHERE (:categoryName IS NULL OR c.name = :categoryName) " +
            "AND (:vendorName IS NULL OR v.link LIKE %:vendorName%) " + // Use LIKE for partial matches
            "AND (:minPrice IS NULL OR i.pricePerUnit >= :minPrice) " +
            "AND (:maxPrice IS NULL OR i.pricePerUnit <= :maxPrice)")
    List<Item> findAllWithFilters(
            @Param("categoryName") String categoryName,
            @Param("vendorName") String vendorName,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice
    );
}

