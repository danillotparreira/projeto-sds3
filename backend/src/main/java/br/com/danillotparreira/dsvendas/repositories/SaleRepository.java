package br.com.danillotparreira.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danillotparreira.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
