package com.dav.customerflow.mapper;

import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    Product productDtoToProduct(ProductDto productDto);

    Product ProductToProductDto(ProductDto productDto);
}
