package com.bwgjoseph.springsecuritycustompreauthenticationflow;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bwgjoseph.springsecuritycustompreauthenticationflow.security.WebSecurityConfig;

@WebMvcTest(MeController.class)
@Import(WebSecurityConfig.class)
class MeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenCallMe_shouldGetValidResponse() throws Exception {
        this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/me")
                .header("X-User", "joseph"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("joseph"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.authorities").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$.authorities[0].authority").value("ADMIN"))
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void whenCallMe_shouldGetValidResponse_withExtraHeaders() throws Exception {
        this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/me")
                .header("X-User", "joseph")
                .header("X-Authorities", "moderator,user"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("joseph"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.authorities").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$.authorities[0].authority").value("moderator"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.authorities[1].authority").value("user"))
            .andDo(MockMvcResultHandlers.print());
    }
}
