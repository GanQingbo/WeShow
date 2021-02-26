package com.gqb.show.service.Impl;

import com.gqb.show.dao.ShowTypeDao;
import com.gqb.show.entity.ShowType;
import com.gqb.show.service.ShowTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowTypeServiceImpl
 * @Description
 * @date 2021/2/25 11:45
 */
@Service
public class ShowTypeServiceImpl implements ShowTypeService {
    @Resource
    private ShowTypeDao showTypeDao;

    @Override
    public int createShowType(ShowType showType) {
        if(showType!=null){
            return showTypeDao.createShowType(showType);
        }
        return -1;
    }

    @Override
    public List<ShowType> selectAllShowType() {
        List<ShowType> list=showTypeDao.selectAllShowType();
        return list;
    }
}
