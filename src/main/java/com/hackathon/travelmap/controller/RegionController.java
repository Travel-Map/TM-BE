package com.hackathon.travelmap.controller;

import com.hackathon.travelmap.domain.Region;
import com.hackathon.travelmap.dto.ResponseDto.RegionResponseDto;
import com.hackathon.travelmap.service.RegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;

    @GetMapping("/list")
    public ResponseEntity<List<RegionResponseDto>> getAllRegions() {
        List<RegionResponseDto> regions = regionService.findAll();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/{id}") // ture or false를 반환하기 위해 visited를 추가
    public ResponseEntity<RegionResponseDto> isVisited(@PathVariable("id") Long id) { // id에 따른 방문 여부 메서드
//        log.info("/region/{id}/visited에 대한 GET 요청 처리", id);
        return ResponseEntity.ok(regionService.findRegion(id));
    }

}
