package lk.artstore.spring.service.impl;

import lk.artstore.spring.dto.MemberDTO;
import lk.artstore.spring.dto.UserDTO;
import lk.artstore.spring.entity.Member;
import lk.artstore.spring.entity.User;
import lk.artstore.spring.repository.MemberRepository;
import lk.artstore.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository repository;

    @Override
    public ArrayList<MemberDTO> getAllMembers() {
        List<Member> members = repository.findAll();

        ArrayList<MemberDTO> alMembers = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = new MemberDTO(
                    new UserDTO(member.getUser().getUsername(), member.getUser().getPassword()),
                    member.getFirstName(),
                    member.getLastName(),
                    member.getEmail(),
                    member.getAddress1(),
                    member.getAddress2(),
                    member.getCity(),
                    member.getCountry(),
                    member.getZip(),
                    member.getDescription(),
                    member.getImage()
            );

            alMembers.add(memberDTO);
        }

        return alMembers;
    }

    @Override
    public MemberDTO getMember(User user) {
        Member member = repository.findById(user).get();
        MemberDTO memberDTO = new MemberDTO(
                new UserDTO(member.getUser().getUsername(), member.getUser().getPassword()),
                member.getFirstName(),
                member.getLastName(),
                member.getEmail(),
                member.getAddress1(),
                member.getAddress2(),
                member.getCity(),
                member.getCountry(),
                member.getZip(),
                member.getDescription(),
                member.getImage()
        );
        return memberDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteMember(User user) {

        repository.deleteById(user);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveMember(MemberDTO memberDTO) {


        Member member = new Member(
                memberDTO.getUserDTO().getUsername(),
                new User(memberDTO.getUserDTO().getUsername(), memberDTO.getUserDTO().getPassword()),
                memberDTO.getFirstName(),
                memberDTO.getLastName(),
                memberDTO.getEmail(),
                memberDTO.getAddress1(),
                memberDTO.getAddress2(),
                memberDTO.getCity(),
                memberDTO.getCountry(),
                memberDTO.getZip(),
                memberDTO.getDescription(),
                memberDTO.getImage()
        );
        repository.save(member);

        return true;
    }


}
