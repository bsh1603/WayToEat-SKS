package bkk.waytoeat.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "storedate")
@Getter @Setter
@NoArgsConstructor
public class StoreDate {

    @Id
    @GeneratedValue
    private Long dateId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;

    private String closed;
    private String workMon;
    private String workTue;
    private String workWed;
    private String workThu;
    private String workFri;
    private String workSat;
    private String workSun;
}

