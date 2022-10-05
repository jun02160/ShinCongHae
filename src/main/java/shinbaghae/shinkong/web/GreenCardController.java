package shinbaghae.shinkong.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shinbaghae.shinkong.domain.GreenCard;
import shinbaghae.shinkong.domain.GreenCardRepository;
import shinbaghae.shinkong.service.GreenCardService;

@Controller
@RequestMapping("/greencard")
@RequiredArgsConstructor
public class GreenCardController {

    private final GreenCardRepository greenCardRepository;
    private final GreenCardService greenCardService;


    /**
     * 그린카드 리스트 페이지
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listPage(Model model) {
        model.addAttribute("cards", greenCardService.list());
        System.out.println(greenCardService.list());
        return "index";
    }
    
    /**
     * 그린카드 등록 페이지
     * @param greenCardRequestDto
     * @return
     */
    @GetMapping("/register")
    public String registerPage(@ModelAttribute("greenCardRequestDto") GreenCardRequestDto greenCardRequestDto) {
        return "register";
    }

    /**
     * 그린카드 등록 로직
     * @param greenCard
     * @return
     */
    @PostMapping("/register")
    public String registerGreenCard(GreenCardRequestDto greenCard) {
        greenCardService.register(greenCard, 1L);
        return "redirect:/";
    }

    /**
     * 그린카드 수정 페이지
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Long id, Model model) {
        GreenCard greenCard = greenCardService.detail(id);
        model.addAttribute("greenCard", greenCard);
        return "update";
    }

    /**
     * 그린카드 수정 로직
     * @param id
     * @param greenCard
     * @return
     */
    @PostMapping("/update/{id}")
    public String updateGreenCard(@PathVariable("id") Long id, GreenCardRequestDto greenCard) {
        greenCardService.update(id, greenCard);
        return "redirect:/";
    }

    /**
     * 그린카드 삭제 로직
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        greenCardService.delete(id);
        return "redirect:/";
    }
}
