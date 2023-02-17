package bkk.waytoeat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "member")
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "memberId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store memberStore;

    @NotNull
    @Size(min = 2)
    private String nickname;

    @NotNull
    @Size(min = 2)
    private String password;

    @NotNull
    @Size(min = 2)
    private String comment;
}
