package shinbaghae.shinkong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shinbaghae.shinkong.domain.GreenCard;
import shinbaghae.shinkong.domain.GreenCardRepository;
import shinbaghae.shinkong.domain.Member;
import shinbaghae.shinkong.domain.MemberRepository;
import shinbaghae.shinkong.web.GreenCardRequestDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GreenCardService {
    
    private final GreenCardRepository greenCardRepository;
    private final MemberRepository memberRepository;

    /**
     * 그린카드 리스트
     * @return
     */
    public List<GreenCard> list() {
        return greenCardRepository.findAll();
    }

    /**
     * 그린카드 등록
     * @param greenCard
     */
    public void register(GreenCardRequestDto greenCard, Long memberId) {
        GreenCard card = greenCard.toEntity();
        Member member = memberRepository.findById(memberId).get();
        greenCardRepository.save(card);
        if (isSameCard(card, member))
            member.setGreedCard(card);
    }

    /**
     * 그린카드 정보 페이지
     * @param cardId
     * @return
     */
    public GreenCard detail(Long cardId) {
        return greenCardRepository.findById(cardId).get();
    }

    /**
     * 그린카드 정보 업데이트
     * @param cardId
     * @param updateCard
     */
    public void update(Long cardId, GreenCardRequestDto updateCard) {
        GreenCard greenCard = greenCardRepository.findById(cardId).get();
        greenCard.update(updateCard.toEntity());
    }

    /**
     * 그린카드 삭제
     * @param cardId
     */
    public void delete(Long cardId) {
        greenCardRepository.deleteById(cardId);
    }


    // TODO Member의 GreenGrade == GreenCard의 GreenGrade인 경우에만 Member 카드로 등록되도록

    /**
     * 멤버의 그린지수에 해당하는 그린카드를 설정하기 위해 같은 등급인지 체크하는 메소드
     * @param card
     * @param member
     * @return
     */
    public boolean isSameCard(GreenCard card, Member member) {
        boolean result = false;
        if (card.getGreenGrade() == member.getGreenGrade())
            result = true;

        return result;
    }
}
