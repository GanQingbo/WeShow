package com.gqb.show.dao;

import com.gqb.show.entity.ShowComment;
import com.gqb.show.entity.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowCommentDao
 * @Description
 * @date 2021/4/22 22:31
 */
@Mapper
public interface ShowCommentDao {
    List<CommentVo> getCommentByShow(@Param("id") Long id);
    List<CommentVo> getCommentByUser(@Param("id") Long id);
    int createComment(ShowComment showComment);
    int deleteComment(@Param("id") Long id);
}
