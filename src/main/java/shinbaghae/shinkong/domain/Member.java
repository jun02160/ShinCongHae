package shinbaghae.shinkong.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="MEMBER")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id", unique = true, nullable = false)
    private Long memberId;
    
    @Column
    private Integer product = 0;   // 저탄소제품 구매량
    
    @Column
    private Integer traffic = 0;   // 대중교통 이용량
    
    @Column
    private Integer trade = 0;     // 중고거래 이용량
    
    @Column
    private Integer greenScore = 0;   // 그린지수

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GreenGrade greenGrade;

    @OneToOne
    @JoinColumn(name="card_id")
    private GreenCard greedCard;

    @Builder
    public Member(Integer product, Integer traffic, Integer trade, Integer greenScore, GreenGrade greenGrade) {
        this.product = product;
        this.traffic = traffic;
        this.trade = trade;
        this.greenScore = greenScore;
        this.greenGrade = greenGrade;
    }

}
