package br.com.danillotparreira.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.danillotparreira.dsvendas.dto.SaleSuccessDTO;
import br.com.danillotparreira.dsvendas.dto.SaleSumDTO;
import br.com.danillotparreira.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new br.com.danillotparreira.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new br.com.danillotparreira.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
	
}
