package com.example.risingwave.dao;

import com.example.risingwave.bo.CampaignBo;
import com.example.risingwave.response.CountCampaingStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository {

    List<CampaignBo> findAll();

    List<CountCampaingStatus> countCampaignByStatus();
}
