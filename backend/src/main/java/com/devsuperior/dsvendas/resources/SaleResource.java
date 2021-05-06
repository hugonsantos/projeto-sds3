package com.devsuperior.dsvendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleResource {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> sale = service.findAll(pageable);
		return ResponseEntity.ok().body(sale);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<SaleDTO> find(@PathVariable Long id) {
		SaleDTO sale = service.findSale(id);
		return ResponseEntity.ok().body(sale);
	}
	
	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller() {
		List<SalesSumDTO> sales = service.amountGroupedBySeller();
		return ResponseEntity.ok().body(sales);
	}
	
	@GetMapping(value="/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller() {
		List<SalesSuccessDTO> sales = service.successGroupedBySeller();
		return ResponseEntity.ok().body(sales);
	}
}
