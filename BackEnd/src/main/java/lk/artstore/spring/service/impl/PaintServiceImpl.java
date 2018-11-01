package lk.artstore.spring.service.impl;


import lk.artstore.spring.dto.MemberDTO;
import lk.artstore.spring.dto.PaintDTO;

import lk.artstore.spring.entity.Member;
import lk.artstore.spring.entity.Paint;
import lk.artstore.spring.entity.User;
import lk.artstore.spring.repository.MemberRepository;
import lk.artstore.spring.repository.PaintRepository;
import lk.artstore.spring.service.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PaintServiceImpl implements PaintService {

    @Autowired
    private PaintRepository repository;
    @Autowired
    private MemberRepository memRepository;


    @Override
    public ArrayList<PaintDTO> getAllPaintings() {
        List<Paint> paintings = repository.findAll();

        ArrayList<PaintDTO> alPaintings = new ArrayList<>();


        for (Paint painting : paintings) {
            User user = new User();
            user.setUsername(painting.getMember().getUser().getUsername());
            PaintDTO paintDTO = new PaintDTO(
                    painting.getId(),
                    new MemberServiceImpl().getMember(user),
                    painting.getTitle(),
                    painting.getDescription(),
                    painting.getImg(),
                    painting.getPrice()
            );

            alPaintings.add(paintDTO);
        }

        return alPaintings;
    }

    @Override
    public PaintDTO getPainting(int id) {
        Paint painting = repository.findById(id).get();
        User user = new User();
        user.setUsername(painting.getMember().getUser().getUsername());
        PaintDTO paintDTO = new PaintDTO(
                painting.getId(),
                new MemberServiceImpl().getMember(user),
                painting.getTitle(),
                painting.getDescription(),
                painting.getImg(),
                painting.getPrice()
        );
        return paintDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deletePainting(int id) {

        repository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean savePainting(PaintDTO paintDTO) {
        User user = new User(paintDTO.getMemberDTO().getUserDTO().getUsername(), paintDTO.getMemberDTO().getUserDTO().getPassword());
        Member mem = memRepository.getOne(user);

        Paint paint = new Paint(
                mem,
                paintDTO.getTitle(),
                paintDTO.getDescription(),
                paintDTO.getImg(),
                paintDTO.getPrice()
        );
        repository.save(paint);

        return true;
    }

}
