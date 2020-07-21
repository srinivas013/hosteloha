package com.RestAPI.hosteloha.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestAPI.hosteloha.DAO.ProductOutputDAO;
import com.RestAPI.hosteloha.model.Product;
import com.RestAPI.hosteloha.service.ProductService;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select * from product where id IN :list" , nativeQuery = true)
	List<Product> getProductsbyId(@Param("list")List<Integer> productids);

	@Query(value = "select p.id,p.product_title,p.subtitle,p.description,p.cost_price,p.selling_price,p.currency,p.quantity,p.users_id,p.condition_id,\n" + 
			"p.delivery_format_id,p.payment_option_id,p.selling_format_id,c.category_name,c.sub_category1,c.sub_category2 from product as p \n" + 
			"left join category as c on p.category_id=c.id\n" + 
			"left join product_image as i on p.id=i.productid" , nativeQuery = true)
	List<ProductOutputDAO> findAllProducts();

	
	@Modifying
	@Query(value= "update product set product_state = :state where id = :productid ", nativeQuery = true)
	int updateProductState(@Param("productid")int productid, @Param("state")String state);

//	@Query(value = "select * from product as p Left Outer join product_image as i on p.id=i.productid",nativeQuery = true)
//	List<Product> getAllProducts();
	@Query("select p from Product p inner join Category c on p.category_id=c.id  where c.category_name=:category" )
	Page<Product> findProductsByCategoryName(@Param("category")String category, Pageable pageable);
	
	@Query("select p from Product p inner join Category c on p.category_id=c.id inner join ProductViews as v on p.id=v.product_id "
			+ "where c.category_name=:category order by v.views_count desc" )
	Page<Product> findByProductProductViewsViews_count(@Param("category")String category, Pageable pageable);
	
}
