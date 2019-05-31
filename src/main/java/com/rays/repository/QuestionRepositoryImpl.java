package com.rays.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import com.rays.common.Log;
import com.rays.entity.Question;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {

    String QUERY_QUESTION_BY_ID = "select * from question where question_id = ?";
    
    @Autowired
    JdbcOperations jdbcOpt;
    
    public QuestionRepositoryImpl() {
        Log.p("init QuestionRepositoryImpl");
    }
    
    @Override
    public List<Question> selectQuestion(long max, int count) {
        return null;
    }

    @Override
    public Question selectSingleQuestion(Long id) {
        Question q = jdbcOpt.queryForObject(QUERY_QUESTION_BY_ID, this::mapRow, id);
        return q;
    }
    
    public Question mapRow(ResultSet rs, int arg1) throws SQLException {
        Question q = new Question();
        q.setId(rs.getLong("question_id"));
        q.setTitle(rs.getString("question_title"));
        q.setDescrible(rs.getString("question_content"));
        q.setCreateDate(rs.getDate("create_date"));
        q.setAuthorId(rs.getLong("author_id"));
        return q;
    }

}
