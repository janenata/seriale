package com.izanat.Dao.CommentDAO;

import com.izanat.Entity.Comment;
import java.util.List;

/**
 * Created by Nathalie on 10.04.2017.
 */
public interface CommentDaoInterface {
    List<Comment> getAllComments();
    void deleteComment(Comment comment);
    void addComment(Comment comment);
}
