package com.demo.SpringBootREST.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.SpringBootREST.beans.Product;
import com.demo.SpringBootREST.dto.ProductDto;

public class ProductDTOMapper {
	
	public static ProductDto mapToProductDto(Product p) {
		if(p.getdate() != null)
			return new ProductDto(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),
					p.getdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),p.getCid());
		else
			return new ProductDto(p.getPid(),p.getPname(),p.getQty(),p.getPrice(),null,p.getCid());
	}
	public static Product mapToProduct(ProductDto pdto) {
		return new Product(pdto.getPid(),pdto.getPname(),pdto.getQty(),pdto.getPrice(),
				LocalDate.parse(pdto.getLdstr(),DateTimeFormatter.ofPattern("dd/MM/yyyy")),pdto.getCid());
	}
}
