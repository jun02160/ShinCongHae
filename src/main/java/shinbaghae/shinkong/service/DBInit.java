package shinbaghae.shinkong.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import shinbaghae.shinkong.domain.*;
import shinbaghae.shinkong.web.GreenCardRequestDto;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DBInit implements CommandLineRunner {

    private final GreenCardRepository greenCardRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        this.memberRepository.deleteAll();
        this.greenCardRepository.deleteAll();

        Member member1 = new Member(14000, 208000, 73000, 0, GreenGrade.PEA);
        Member member2 = new Member(0, 0, 0, 0, GreenGrade.PEA);

        GreenCard seedCard = new GreenCard("green", GreenGrade.SEED);
        GreenCard sproutCard = new GreenCard("green", GreenGrade.SPROUT);
        GreenCard peaCard = new GreenCard("green", GreenGrade.PEA);
        GreenCard kingCard = new GreenCard("green", GreenGrade.KING);

        List<Member> memberList = Arrays.asList(member1, member2);
        List<GreenCard> cardList = Arrays.asList(seedCard, sproutCard, peaCard, kingCard);

        this.memberRepository.saveAll(memberList);   // Test용 하나의 유저만 저장하여 운영
        this.greenCardRepository.saveAll(cardList);
        System.out.println(this.greenCardRepository.findAll());
    }
}
