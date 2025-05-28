package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSumaryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SaleSumaryProjection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("""
    SELECT new com.devsuperior.dsmeta.dto.SaleReportDTO(
        obj.id,
        obj.amount,
        obj.date,
        obj.seller.name
    )
    FROM Sale obj
    WHERE obj.date BETWEEN :minDate AND :maxDate
      AND LOWER(obj.seller.name) LIKE LOWER(CONCAT('%', :name, '%'))
""")
    Page<SaleReportDTO> getReport(
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate,
            @Param("name") String name,
            Pageable pageable
    );

    //Usando Native Query 
    @Query(nativeQuery = true, value = """
            SELECT TB_SELLER.NAME, ROUND(SUM(TB_SALES.AMOUNT),2)
            FROM TB_SELLER
            INNER JOIN TB_SALES
            ON TB_SALES.SELLER_ID = TB_SELLER.ID
            WHERE TB_SALES.DATE BETWEEN :minDate AND :maxDate
            GROUP BY TB_SELLER.NAME
            """)
    Page<SaleSumaryProjection>sumaryByNativeQuery(
        @Param("minDate") LocalDate minDate,
        @Param("maxDate") LocalDate maxDate,
        Pageable pageable
    );

    //Usando JPQL
    @Query("""
            SELECT new com.devsuperior.dsmeta.dto.SaleSumaryDTO(obj.seller.name, SUM(obj.amount))
            FROM Sale obj
            WHERE obj.date BETWEEN :minDate AND :maxDate
            GROUP BY obj.seller.name
            """)
    Page<SaleSumaryDTO>summaryByJpql(
        @Param("minDate") LocalDate minDate,
        @Param("maxDate") LocalDate maxDate,
        Pageable pageable
    );


}
