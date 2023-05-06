package com.example.risingwave.service.facade;

import com.example.risingwave.bo.CampaignBo;
import com.example.risingwave.response.CountCampaingStatus;

import java.util.List;

public interface CampaingService {
    List<CampaignBo> findAll();

    List<CountCampaingStatus> countCampaignByStatus();

}
