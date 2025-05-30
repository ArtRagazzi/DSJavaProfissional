package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSumaryDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleSumaryProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> getReport(String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate today = LocalDate.now();

		LocalDate min = (minDate == null || minDate.isBlank()) ? today.minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = (maxDate == null || maxDate.isBlank()) ? today : LocalDate.parse(maxDate);

		return repository.getReport(min, max, name, pageable);
	}


	public Page<SaleSumaryDTO> getSumaryByNativeQuery(String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.now();

		LocalDate min = (minDate == null || minDate.isBlank()) ? today.minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = (maxDate == null || maxDate.isBlank()) ? today : LocalDate.parse(maxDate);

		Page<SaleSumaryProjection> obj = repository.sumaryByNativeQuery(min, max, pageable);
		Page<SaleSumaryDTO> objDTO = obj.map(SaleSumaryDTO::new);
		return objDTO;
	}

	public Page<SaleSumaryDTO> getSumaryByJpql(String minDate, String maxDate, Pageable pageable) {
		LocalDate today = LocalDate.now();

		LocalDate min = (minDate == null || minDate.isBlank()) ? today.minusYears(1) : LocalDate.parse(minDate);
		LocalDate max = (maxDate == null || maxDate.isBlank()) ? today : LocalDate.parse(maxDate);

		Page<SaleSumaryDTO> objDTO = repository.summaryByJpql(min, max, pageable);
		return objDTO;
	}
}
