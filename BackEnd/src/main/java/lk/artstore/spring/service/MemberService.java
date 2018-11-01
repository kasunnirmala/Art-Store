package lk.artstore.spring.service;

import lk.artstore.spring.dto.MemberDTO;
import lk.artstore.spring.entity.User;

import java.util.ArrayList;

public interface MemberService {
    public ArrayList<MemberDTO> getAllMembers();

    public MemberDTO getMember(User user);

    public boolean deleteMember(User user);

    public boolean saveMember(MemberDTO memberDTO);

}
