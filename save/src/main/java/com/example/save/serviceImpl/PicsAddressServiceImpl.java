package com.example.save.serviceImpl;

import com.example.save.bean.PicsAddress;
import com.example.save.bean.PicsAddressResult;
import com.example.save.dao.PicsAddressDao;
import com.example.save.service.PicsAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicsAddressServiceImpl implements PicsAddressService {
    @Autowired
    PicsAddressDao picsAddressDao;

    @Override
    public PicsAddressResult picsAddress() {
        PicsAddress[] picsAddress = picsAddressDao.picsAddress();
        PicsAddressResult picsAddressResult = new PicsAddressResult();

        if(picsAddress == null){
            picsAddressResult.setStatus(10001);
            picsAddressResult.setInfor("error");
            return picsAddressResult;
        }

        picsAddressResult.setStatus(10000);
        picsAddressResult.setInfor("success");
        picsAddressResult.setPicsAddress(picsAddress);
        return picsAddressResult;
    }
}
