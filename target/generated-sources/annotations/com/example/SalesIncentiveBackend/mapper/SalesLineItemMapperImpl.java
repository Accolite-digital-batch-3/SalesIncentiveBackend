package com.example.SalesIncentiveBackend.mapper;

import com.example.SalesIncentiveBackend.dto.SalesLineItemDto;
import com.example.SalesIncentiveBackend.model.SalesLineItem;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T19:21:35+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
public class SalesLineItemMapperImpl implements SalesLineItemMapper {

    @Override
    public SalesLineItemDto modelToDto(SalesLineItem salesLineItem) {
        if ( salesLineItem == null ) {
            return null;
        }

        SalesLineItemDto salesLineItemDto = new SalesLineItemDto();

        salesLineItemDto.setSalesId( salesLineItem.getSalesId() );
        salesLineItemDto.setSoldDate( salesLineItem.getSoldDate() );
        salesLineItemDto.setSoldCost( salesLineItem.getSoldCost() );

        return salesLineItemDto;
    }

    @Override
    public SalesLineItem dtoToModel(SalesLineItemDto salesLineItemDto) {
        if ( salesLineItemDto == null ) {
            return null;
        }

        SalesLineItem salesLineItem = new SalesLineItem();

        salesLineItem.setSalesId( salesLineItemDto.getSalesId() );
        salesLineItem.setSoldDate( salesLineItemDto.getSoldDate() );
        salesLineItem.setSoldCost( salesLineItemDto.getSoldCost() );

        return salesLineItem;
    }
}
