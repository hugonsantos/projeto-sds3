package com.devsuperior.dsvendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;

@RestController
@RequestMapping(value="/sellers")
public class SellerResource {

	@Autowired
	private SellerService service;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(Long id) {
		List<SellerDTO> seller = service.findAll();
		return ResponseEntity.ok().body(seller);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<SellerDTO> find(@PathVariable Long id) {
		SellerDTO seller = service.findSeller(id);
		return ResponseEntity.ok().body(seller);
	}
}
