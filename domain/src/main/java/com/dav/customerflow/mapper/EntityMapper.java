package com.dav.customerflow.mapper;

import com.dav.customerflow.dto.CategoryDto;
import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.entity.Category;
import com.dav.customerflow.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product productDto);

    List<ProductDto> productListToProductDtoList(List<Product> products);

    CategoryDto categoryToCategoryDto(Category category);

    List<CategoryDto> categoryListToCategoryDtoList(List<Category> categories);
}
