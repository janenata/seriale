package com.izanat.Dao.CommentDAO;

import com.izanat.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nathalie on 10.04.2017.
 */
@Repository
public class CommentDao implements CommentDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //przetestowane

    @Override
    public List<Comment> getAllComments() {
        final String query = "SELECT comment_id, comment_title, comment_text, login, title FROM comments";
        List<Comment> comments = jdbcTemplate.query(query, new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
                Comment comment = new Comment();
                comment.setCommentId(resultSet.getInt("comment_id"));
                comment.setCommentTitle(resultSet.getString("comment_title"));
                comment.setCommentText(resultSet.getString("comment_text"));
                comment.setLogin(resultSet.getString("login"));
                comment.setTitle(resultSet.getString("title"));
                return comment;
            }
        });
        return comments;
    }

    @Override
    public void deleteComment(Integer commentId) {
        final String query = "DELETE FROM comments WHERE comment_id = ?";
        jdbcTemplate.update(query, commentId);
    }

    @Override
    public void addComment(Comment comment) {
        final String query = "INSERT INTO comments(comment_title, comment_text, login, title) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[]{comment.getCommentTitle(), comment.getCommentText(), comment.getLogin(), comment.getTitle()});
    }
}
