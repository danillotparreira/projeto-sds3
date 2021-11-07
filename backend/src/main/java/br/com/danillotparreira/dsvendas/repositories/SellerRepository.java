package br.com.danillotparreira.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danillotparreira.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
