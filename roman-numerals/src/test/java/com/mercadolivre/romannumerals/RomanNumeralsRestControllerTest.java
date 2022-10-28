package com.mercadolivre.romannumerals;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RomanNumeralsRestController.class)
class RomanNumeralsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void toRoman_returnI_whenSuccess() throws Exception {
        mockMvc.perform(
                        get("/{number}", 1)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().equals("I");
    }

    @Test
    void toRoman_returnIII_whenSuccess() throws Exception {
        mockMvc.perform(
                        get("/{number}", 3)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().equals("III");
    }

    @Test
    void toRoman_returnV_whenSuccess() throws Exception {
        mockMvc.perform(
                        get("/{number}", 5)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().equals("V");
    }

    @Test
    void toRoman_returnVII_whenSuccess() throws Exception {
        mockMvc.perform(
                        get("/{number}", 7)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().equals("VII");
    }

    @Test
    void toRoman_returnX_whenSuccess() throws Exception {
        mockMvc.perform(
                        get("/{number}", 10)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().equals("X");
    }

    @Test
    void toRoman_returnL_whenSuccess() throws Exception {
        mockMvc.perform(
                        get("/{number}", 50)
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().equals("L");
    }

}