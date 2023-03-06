package bkk.waytoeat.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ResponseStoreDetailDto {
    private String id;
    private String name;
    private Date naverRatingDate;
    private double naverRating;
    private Date kakaoRatingDate;
    private double kakaoRating;
    private double selfRating;
    private String phone;
    private String closed;
    private String workMon;
    private String workTue;
    private String workWed;
    private String workThu;
    private String workFri;
    private String workSat;
    private String workSun;
    private String menuImage;

    public ResponseStoreDetailDto(String id, String name,
                                  Date naverRatingDate, double naverRating,
                                  Date kakaoRatingDate, double kakaoRating, double selfRating,
                                  String phone, String closed,
                                  String workMon, String workTue, String workWed,
                                  String workThu, String workFri, String workSat,
                                  String workSun, String menuImage) {
        this.id = id;
        this.name = name;
        this.naverRatingDate = naverRatingDate;
        this.naverRating = naverRating;
        this.kakaoRatingDate = kakaoRatingDate;
        this.kakaoRating = kakaoRating;
        this.selfRating = selfRating;
        this.phone = phone;
        this.closed = closed;
        this.workMon = workMon;
        this.workTue = workTue;
        this.workWed = workWed;
        this.workThu = workThu;
        this.workFri = workFri;
        this.workSat = workSat;
        this.workSun = workSun;
        this.menuImage = menuImage;
    }
}
