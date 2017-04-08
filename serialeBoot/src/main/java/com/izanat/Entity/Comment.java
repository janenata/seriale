package com.izanat.Entity;

/**
 * Created by Nathalie on 08.04.2017.
 */
public class Comment {
    private Integer commentId;
    private String commentTitle;
    private String commentText;
    private String title;
    private String login;

    public Comment(Integer commentId, String commentTitle, String commentText, String title, String login) {
        this.commentId = commentId;
        this.commentTitle = commentTitle;
        this.commentText = commentText;
        this.title = title;
        this.login = login;
    }

    public Comment() {
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
