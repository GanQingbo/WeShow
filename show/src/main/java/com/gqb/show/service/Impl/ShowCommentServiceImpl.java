package com.gqb.show.service.Impl;

import com.gqb.show.dao.ShowCommentDao;
import com.gqb.show.entity.ShowComment;
import com.gqb.show.entity.vo.CommentVo;
import com.gqb.show.service.ShowCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowCommentServiceImpl
 * @Description
 * @date 2021/4/22 22:29
 */
@Service
@Slf4j
public class ShowCommentServiceImpl implements ShowCommentService {
    @Resource
    private ShowCommentDao showCommentDao;

    @Override
    public List<CommentVo> getCommentByShow(Long id) {
        List<CommentVo> commentByShow = showCommentDao.getCommentByShow(id);
        return commentByShow;
    }

    @Override
    public int createComment(ShowComment showComment) {
        int comment = showCommentDao.createComment(showComment);
        return comment;
    }

    @Override
    public int deleteComment(Long id) {
        int i = showCommentDao.deleteComment(id);
        return i;
    }

    @Override
    public List<CommentVo> getCommentByUser(Long id) {
        List<CommentVo> commentByUser = showCommentDao.getCommentByUser(id);
        return commentByUser;
    }
}
