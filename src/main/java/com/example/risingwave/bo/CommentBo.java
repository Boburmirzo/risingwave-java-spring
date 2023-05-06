package com.example.risingwave.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class CommentBo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CONTENU")
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_bo_id")
    private UserBo userBo;

    @ManyToOne
    @JoinColumn(name = "campaign_bo_id")
    private CampaignBo campaignBo;

}
