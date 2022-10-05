package shinbaghae.shinkong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shinbaghae.shinkong.domain.Member;
import shinbaghae.shinkong.domain.MemberRepository;
import shinbaghae.shinkong.service.MemberService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/mypage")
    public List<String> homePage() throws Exception {
        Member member = memberService.getMyPage(1L);
        memberService.changeGreenCard(1L);

        List<String> strList = new ArrayList<>();
        strList.add(String.valueOf(member.getProduct()));
        strList.add(String.valueOf(member.getTraffic()));
        strList.add(String.valueOf(member.getTrade()));
        strList.add(String.valueOf(member.getGreenScore()));
        strList.add(member.getGreenGrade().getValue());
        strList.add(member.getGreedCard().getGreenGrade().getValue());

        return strList;
    }
}
