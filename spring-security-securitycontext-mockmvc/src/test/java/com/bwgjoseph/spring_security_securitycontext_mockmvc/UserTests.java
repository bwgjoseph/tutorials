package com.bwgjoseph.spring_security_securitycontext_mockmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultHandlers.exportTestSecurityContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional // allow for rollback after test
@SpringBootTest
@AutoConfigureMockMvc
public class UserTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository repository;

    @Test
    @WithMockUser(value = "bwgjoseph")
    void securityContext_whenNotExported_willFail() throws Exception {
        this.mockMvc.perform(post("/api/v1/users/{name}", "bwgjoseph")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        assertThatThrownBy(() -> this.repository.findByName()).isExactlyInstanceOf(SpelEvaluationException.class);
    }

    @Test
    @WithMockUser(value = "bwgjoseph")
    void securityContext_whenExported_willPass() throws Exception {
        this.mockMvc.perform(post("/api/v1/users/{name}", "bwgjoseph")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(exportTestSecurityContext())
                .andExpect(status().isCreated());

        var user = this.repository.findByName();

        assertThat(user.get()).extracting("name").isEqualTo("bwgjoseph");
    }
}
