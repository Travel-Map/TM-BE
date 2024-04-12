package com.hackathon.travelmap.service;

import com.hackathon.travelmap.domain.Region;
import com.hackathon.travelmap.dto.ResponseDto.RegionResponseDto;
import com.hackathon.travelmap.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionResponseDto findRegion(Long regionId){
        Region region = regionRepository.findById(regionId).orElseThrow(() -> new RuntimeException("지역을 찾을 수 없습니다."));
        RegionResponseDto responseDto = RegionResponseDto.of(region); // DTO 변환
        return responseDto;
    }
    public List<RegionResponseDto> findAll() {
        List<Region> list = regionRepository.findAll();
        return list.stream().map(RegionResponseDto::of).toList();
    }

}
