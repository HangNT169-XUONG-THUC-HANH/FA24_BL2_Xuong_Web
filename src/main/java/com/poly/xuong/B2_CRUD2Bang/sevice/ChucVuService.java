package com.poly.xuong.B2_CRUD2Bang.sevice;

import com.poly.xuong.B2_CRUD2Bang.entity.ChucVu;
import com.poly.xuong.B2_CRUD2Bang.repository.ChucVuRepository;

import java.util.List;

public class ChucVuService {

    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }
}
