package shinbaghae.shinkong.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="GREENCARD")
public class GreenCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id", unique = true, nullable = false)
    private Long cardId;

    @Column
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GreenGrade greenGrade;

    @Builder
    public GreenCard(String category, GreenGrade greenGrade) {
        this.category = category;
        this.greenGrade = greenGrade;
    }

    // Card 정보 수정
    public void update(GreenCard card) {
        this.category = card.getCategory();
        this.greenGrade = card.getGreenGrade();
    }


}
