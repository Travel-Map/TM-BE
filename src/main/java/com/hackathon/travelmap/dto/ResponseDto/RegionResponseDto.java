package com.hackathon.travelmap.dto.ResponseDto;

import com.hackathon.travelmap.domain.Region;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegionResponseDto {
    private Long id;
    private String name;
    private Boolean isVisited;

    public static RegionResponseDto of(Region region) {
        return new RegionResponseDto(region.getId(), region.getName(), region.getIsVisited());
    }
}
