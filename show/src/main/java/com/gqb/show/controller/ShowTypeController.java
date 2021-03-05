package com.gqb.show.controller;

import com.gqb.common.utils.R;
import com.gqb.show.entity.ShowType;
import com.gqb.show.service.ShowTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowTypeController
 * @Description
 * @date 2021/2/25 11:49
 */
@RestController
@RequestMapping("/show/showtype")
@CrossOrigin
public class ShowTypeController {
    @Resource
    private ShowTypeService showTypeService;

    @GetMapping("/getAllShowType")
    public R getAllShowType(){
        List<ShowType> list = showTypeService.selectAllShowType();
        return R.ok().data("showType",list);
    }

    /***
    *@Description 插入新的演出类型
    *@param showType
    *@return 新插入记录的id
    */
    @PostMapping("/createShowType")
    public R createShowType(@RequestBody ShowType showType){
        int showTypeId = showTypeService.createShowType(showType);
        if(showTypeId>0){
            return R.ok().data("id",showType.getId());
        }
        return R.error().message("插入异常");
    }
}
