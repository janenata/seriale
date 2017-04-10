package com.izanat.Dao.CommentDAO;

import com.izanat.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nathalie on 10.04.2017.
 */
public class CommentDao implements CommentDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //TO DO: test all

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
    public void deleteComment(Comment comment) {
        final String query = "DELETE FROM comments WHERE comment_id = ?";
        jdbcTemplate.update(query, comment.getCommentId());
    }

    @Override
    public void addComment(Comment comment) {
        final String query = "INSERT INTO comments VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[]{comment.getCommentId(), comment.getCommentTitle(), comment.getCommentText(), comment.getLogin(), comment.getTitle()});
    }
}
