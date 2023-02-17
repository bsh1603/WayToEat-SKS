package bkk.waytoeat.domain;

import bkk.waytoeat.domain.converterClass.BooleanToYesNoConverter;
import bkk.waytoeat.domain.enumClass.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "store")
@Getter @Setter
@NoArgsConstructor
public class Store {

    @Id
    @Column(name = "storeId")
    private String id;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private StoreDate storeDate;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min = 2)
    private String phone;

    @NotNull
    @Size(min = 2)
    private String location;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    private double naverRating;

    @NotNull
    private double kakaoRating;

    @Column(nullable = true)
    private double selfRating;
    private String menuImage;

    @Column(nullable = true)
    @Convert(converter = BooleanToYesNoConverter.class)
    private boolean reservation;
    @Column(nullable = true)
    @Convert(converter = BooleanToYesNoConverter.class)
    private boolean packaging;

    private String detail;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
}





















