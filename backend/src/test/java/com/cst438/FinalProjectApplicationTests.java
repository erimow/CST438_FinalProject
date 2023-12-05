package com.cst438;

import com.cst438.controllers.MediaController;
import com.cst438.domain.Media;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FinalProjectApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllMedia_shouldReturnAllMedia() throws Exception {
        mockMvc.perform(get("/api/media"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void createMedia_shouldCreateNewMedia() throws Exception {
        Media newMedia = new Media(); // Create a new Media object 

        mockMvc.perform(post("/api/media")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newMedia)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void getMediaById_shouldReturnCorrectMedia() throws Exception {
        int mediaId = 1; 

        mockMvc.perform(get("/api/media/{id}", mediaId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
       
    }

    @Test
    public void updateMedia_shouldUpdateExistingMedia() throws Exception {
        int mediaId = 1; 
        Media updatedMedia = new Media(); 
        
        mockMvc.perform(put("/api/media/{id}", mediaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedMedia)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        
    }

    @Test
    public void deleteMedia_shouldDeleteMedia() throws Exception {
        int mediaId = 1; 

        mockMvc.perform(delete("/api/media/{id}", mediaId))
                .andExpect(status().isOk());
      
    }

}
