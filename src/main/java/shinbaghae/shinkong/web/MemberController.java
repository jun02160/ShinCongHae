package shinbaghae.shinkong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shinbaghae.shinkong.domain.GreenCardRepository;
import shinbaghae.shinkong.domain.Member;
import shinbaghae.shinkong.domain.MemberRepository;

import java.util.Optional;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final GreenCardRepository greenCardRepository;

    /**
     * 자신의 그린등급, 그린지수, 그린카드 보유 현황을 확인할 수 있는 마이페이지
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/")
    public String getMyPage(Model model) throws Exception {
        Member member = memberRepository.findById(1L).orElseThrow(
                Exception::new
        );
        model.addAttribute("member", member);
        return "member/mypage";
    }
}
