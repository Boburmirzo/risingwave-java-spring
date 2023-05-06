package com.example.risingwave.bo;

import java.util.Arrays;

public enum CampaignStatus {
  PREPARATION(1),
  PROPOSAL(2),
  DESIGN(3),
  VALIDATED(4),
  IN_PROGRESS(5),
  FINISHED(6),
  INVOICED(7),
  PAID(8),
  CANCELED(9);

  private int order;

  CampaignStatus(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

  public static CampaignStatus get(String name) {
    return Arrays.stream(CampaignStatus.values())
        .filter(item -> item.name().equalsIgnoreCase(name))
        .findFirst()
        .orElse(null);
  }
  public static CampaignStatus get(Integer order) {
    return Arrays.stream(CampaignStatus.values())
            .filter(item -> item.getOrder()== order)
            .findFirst()
            .orElse(null);
  }
}
