package demo.springboot.web;

import demo.springboot.utils.SeqGeneratorUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Hello案例
 *
 * Created by bysocket on 26/09/2017.
 */
@RestController
public class GenSeqController {

    @GetMapping("/getSeq")
    public String getSeq() {
        return String.valueOf(SeqGeneratorUtil.getSeq("USR_ID"));
    }
    @GetMapping("/getOfferSeq")
    public String getSeq1() {
        return String.valueOf(SeqGeneratorUtil.getSeq("OFFER_ID"));
    }
}
