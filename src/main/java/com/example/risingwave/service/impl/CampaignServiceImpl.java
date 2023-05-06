package com.example.risingwave.service.impl;

import com.example.risingwave.bo.CampaignBo;
import com.example.risingwave.dao.CampaignRepository;
import com.example.risingwave.response.CountCampaingStatus;
import com.example.risingwave.service.facade.CampaingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaingService {

    private final CampaignRepository campaignRepository;

    @Override
    public List<CampaignBo> findAll() {
        return campaignRepository.findAll();
    }

    @Override
    public List<CountCampaingStatus> countCampaignByStatus() {
       return campaignRepository.countCampaignByStatus();
    }
}
