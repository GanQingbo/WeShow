package com.gqb.show.controller;

import com.gqb.common.utils.R;
import com.gqb.show.entity.ShowComment;
import com.gqb.show.entity.vo.CommentVo;
import com.gqb.show.service.ShowCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowCommentController
 * @Description
 * @date 2021/4/22 22:13
 */
@RestController
@RequestMapping("/show/comment")
public class ShowCommentController {
    @Resource
    private ShowCommentService showCommentService;

    @GetMapping("/getCommentByShow/{id}")
    public R getCommentByShow(@PathVariable("id") Long id){
        List<CommentVo> commentByShow = showCommentService.getCommentByShow(id);
        return R.ok().data("comment",commentByShow);
    }

    @GetMapping("/getCommentByUser/{id}")
    public R getCommentByUser(@PathVariable("id") Long id){
        List<CommentVo> comments = showCommentService.getCommentByUser(id);
        return R.ok().data("comment",comments);
    }

    @PostMapping("/createComment")
    public R createComment(@RequestBody ShowComment showComment){
        int comment = showCommentService.createComment(showComment);
        if(comment>0){
            return R.ok();
        }
        return R.error();
    }

    @DeleteMapping("/deleteComment/{id}")
    public R deleteComment(@PathVariable("id") Long id){
        int i = showCommentService.deleteComment(id);
        if(i>0){
            return R.ok();
        }
        return R.error();
    }
}
