package com.gqb.show.service;

import com.gqb.show.entity.ShowComment;
import com.gqb.show.entity.vo.CommentVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowComment
 * @Description
 * @date 2021/4/22 22:26
 */
public interface ShowCommentService {
    List<CommentVo> getCommentByShow(Long id);
    int createComment(ShowComment showComment);
    int deleteComment(Long id);
    List<CommentVo>  getCommentByUser(Long id);
}
