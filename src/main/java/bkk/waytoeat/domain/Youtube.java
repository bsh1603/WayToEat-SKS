package bkk.waytoeat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Youtube")
@Getter @Setter
@NoArgsConstructor
public class Youtube {

    @Id @GeneratedValue
    @Column(name = "youtubeId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store storeYoutube;

    @NotNull
    private String url;

    @NotNull
    private String thumbnail;
}
