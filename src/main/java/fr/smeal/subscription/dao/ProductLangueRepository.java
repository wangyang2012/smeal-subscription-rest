package fr.smeal.subscription.dao;

import fr.smeal.subscription.entity.ProductLangueEntity;
import fr.smeal.subscription.entity.ProductLangueEntityPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductLangueRepository extends JpaRepository<ProductLangueEntity, ProductLangueEntityPk> {
    @Query(value = "select name from ps_product_lang where id_product=:productId limit 1", nativeQuery = true)
    String getNameByProductId(@Param("productId") Integer productId);
}
