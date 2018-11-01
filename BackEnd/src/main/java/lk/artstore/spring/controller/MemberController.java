package lk.artstore.spring.controller;

import lk.artstore.spring.dto.MemberDTO;
import lk.artstore.spring.dto.UserDTO;
import lk.artstore.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(value = "api/v1/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveMember(@RequestBody MemberDTO memberDTO) {
        return memberService.saveMember(memberDTO);
    }
}
