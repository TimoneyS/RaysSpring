package com.rays.controller;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.rays.common.Log;
import com.rays.dao.QuestionDao;
import com.rays.entity.Question;

public class TestQuestionController {

    @Test
    public void testQuestionGet() throws Exception {
        
        Question question = createQuestion(123l);
        QuestionDao qr = Mockito.mock(QuestionDao.class);
        
        qr.querySingle(123l);
        Mockito.when(null).thenReturn(question);
        
        Log.p(qr.querySingle(123l));
        
        QuestionController controller = new QuestionController(qr);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/views/question_page.jsp"))
                .build();
        
        mockMvc.perform(MockMvcRequestBuilders.get("/question/123"))
            .andExpect(MockMvcResultMatchers.view().name("question_page"))
            .andExpect(MockMvcResultMatchers.model().attributeExists("question"))
            .andExpect(MockMvcResultMatchers.model().attribute("question", question));
        
    }
    
    private Question createQuestion(Long id) {
        Question question = new Question();
        question.setId(123L);
        question.setTitle("Question " + id + " title");
        question.setContent("Question " + id + " describle");
        return question;
    }
    
}
