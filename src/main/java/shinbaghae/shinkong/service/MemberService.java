package shinbaghae.shinkong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shinbaghae.shinkong.domain.GreenCardRepository;
import shinbaghae.shinkong.domain.Member;
import shinbaghae.shinkong.domain.MemberRepository;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final GreenCardRepository greenCardRepository;

    /**
     * 개인정보 조회
     * @param memberId
     * @return
     * @throws Exception
     */
    public Member getMyPage(Long memberId) throws Exception {
        return memberRepository.findById(memberId).orElseThrow(
                Exception::new
        );
    }

    // TODO 각 소비별 plus 할 가중치 정하기
    /**
     * product: 저탄소제품 구매량 업데이트
     * @param memberId
     */
    public void updateProduct(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Integer productCount = member.getProduct();
        productCount++;   //TODO 여기에 가중치를 더하는 것으로 변경
        member.setProduct(productCount);
    }

    /**
     * traffic: 대중교통 이용량 업데이트
     * @param memberId
     */
    public void updateTraffic(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Integer trafficCount = member.getTraffic();
        trafficCount++;
        member.setTraffic(trafficCount);
    }

    /**
     * trade: 중고거래 이용량 업데이트
     * @param memberId
     */
    public void updateTrade(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Integer tradeCount = member.getTrade();
        tradeCount++;
        member.setTrade(tradeCount);
    }
    
    //TODO 또는 모두 같은 가중치를 주고, 그린지수 계산 시에 다르게 부여해서 계산하는 방식
    /**
     * greenScore: 그린지수 계산
     */
    public int calculateScore(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Integer greenScore = member.getGreenScore();

        // 그린지수 계산식
        greenScore = member.getProduct() *50 + member.getTraffic() *40 + member.getTrade() *10;
        member.setGreenScore(greenScore);
        return greenScore;
    }

    public void changeGreenCard(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        int score = calculateScore(memberId);

        if (score > 100000)
            member.setGreedCard(greenCardRepository.findById(4L).get());
        else if (score > 50000)
            member.setGreedCard(greenCardRepository.findById(3L).get());
        else if (score > 30000)
            member.setGreedCard(greenCardRepository.findById(2L).get());
        else
            member.setGreedCard(greenCardRepository.findById(1L).get());
    }

}
