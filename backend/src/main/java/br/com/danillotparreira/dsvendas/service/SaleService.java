package br.com.danillotparreira.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.danillotparreira.dsvendas.dto.SaleDTO;
import br.com.danillotparreira.dsvendas.dto.SaleSuccessDTO;
import br.com.danillotparreira.dsvendas.dto.SaleSumDTO;
import br.com.danillotparreira.dsvendas.entities.Sale;
import br.com.danillotparreira.dsvendas.repositories.SaleRepository;
import br.com.danillotparreira.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(r -> new SaleDTO(r));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
