package com.example.save.serviceImpl;

import com.example.save.bean.Property;
import com.example.save.bean.TopList;
import com.example.save.bean.TopListResult;
import com.example.save.dao.RankDao;
import com.example.save.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RankServiceImpl implements RankService {

    @Autowired
    RankDao rankDao;

    @Override
    public TopListResult getRank() {

        TopListResult topListResult = new TopListResult();
        TopList[] topLists = rankDao.getRank();

        if(topLists.length == 0){
            topListResult.setStatus(10001);
            topListResult.setInfor("error");
            return topListResult;
        }


        if(topLists.length >= 2 ) {
            for (int i = 0; i < topLists.length - 1; i++) {
                for (int j = 0; j < topLists.length - i - 1; j++) {
                    if (topLists[j].getRice() < topLists[j + 1].getRice()) {
                        TopList temp = topLists[j];
                        topLists[j] = topLists[j + 1];
                        topLists[j + 1] = temp;
                    }
                }
            }
        }

        TopList[] lastTopLists = new TopList[20];
        for (int i = 0; i <= 19; i++) {
            lastTopLists[i] = topLists[i];
        }

        topListResult.setStatus(10000);
        topListResult.setInfor("success");
        topListResult.setProperties(lastTopLists);
        return topListResult;
    }
}
