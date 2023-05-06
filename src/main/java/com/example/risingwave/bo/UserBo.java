package com.example.risingwave.bo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "users")
public class UserBo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "userBo", cascade = CascadeType.ALL)
    private List<CommentBo> commentBoList;

    @OneToMany(mappedBy = "userBo", cascade = CascadeType.ALL)
    private List<CampaignBo> campaignBos;
}
