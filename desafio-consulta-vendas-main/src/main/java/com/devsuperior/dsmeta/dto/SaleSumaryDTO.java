package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SaleSumaryProjection;

public class SaleSumaryDTO {
    private String name;
    private Double sum;

    public SaleSumaryDTO(){}

    public SaleSumaryDTO(String name, Double sum){
        this.name = name;
        this.sum = sum;
    }


    public SaleSumaryDTO(SaleSumaryProjection saleSumaryProjection){
        this.name = saleSumaryProjection.getName();
        this.sum = saleSumaryProjection.getSum();
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getSum(){
        return this.sum;
    }
    public void setSum(Double sum){
        this.sum = sum;
    }

}
