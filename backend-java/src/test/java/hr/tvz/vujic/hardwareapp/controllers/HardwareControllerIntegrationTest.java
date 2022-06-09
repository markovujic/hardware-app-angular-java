package hr.tvz.vujic.hardwareapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareCommand;
import hr.tvz.vujic.hardwareapp.hardware.service.HardwareService;
import hr.tvz.vujic.hardwareapp.security.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
@ContextConfiguration
class HardwareControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllHardware() throws Exception {

        mockMvc.perform(
                get("/hardware")
                .with(
                        user("test").password("test").roles("ADMIN")
                )
                .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(3)));


    }




}