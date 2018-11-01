package lk.artstore.spring.service;

import lk.artstore.spring.dto.PaintDTO;
import lk.artstore.spring.entity.Paint;

import java.util.ArrayList;

public interface PaintService {

    public ArrayList<PaintDTO> getAllPaintings();

    public PaintDTO getPainting(int id);

    public boolean deletePainting(int id);

    public boolean savePainting(PaintDTO paintDTO);
}
