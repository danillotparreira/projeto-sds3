package br.com.danillotparreira.dsvendas.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.net.httpserver.Authenticator.Result;

import br.com.danillotparreira.dsvendas.dto.SellerDTO;
import br.com.danillotparreira.dsvendas.entities.Seller;
import br.com.danillotparreira.dsvendas.repositories.SellerRepository;

@Service
public class SellerServices {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(r -> new SellerDTO(r)).collect(Collectors.toList());
	}
}
