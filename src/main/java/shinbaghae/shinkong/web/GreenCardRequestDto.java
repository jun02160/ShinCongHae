package shinbaghae.shinkong.web;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shinbaghae.shinkong.domain.GreenCard;
import shinbaghae.shinkong.domain.GreenGrade;

@Data
@NoArgsConstructor
public class GreenCardRequestDto {

    private Long id;
    private String category;
    private GreenGrade greenGrade;

    @Builder
    public GreenCardRequestDto(GreenCard greenCard) {
        this.category = greenCard.getCategory();
        this.greenGrade = greenCard.getGreenGrade();
    }

    public GreenCard toEntity() {
        return GreenCard.builder()
                .category(category)
                .greenGrade(greenGrade)
                .build();
    }
}
