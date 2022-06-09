package hr.tvz.vujic.hardwareapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.vujic.hardwareapp.hardware.Hardware;
import hr.tvz.vujic.hardwareapp.hardware.HardwareCommand;
import hr.tvz.vujic.hardwareapp.hardware.repository.HardwareRepository;
import hr.tvz.vujic.hardwareapp.hardware.service.HardwareService;
import hr.tvz.vujic.hardwareapp.security.login.Authority;
import hr.tvz.vujic.hardwareapp.security.login.User;
import hr.tvz.vujic.hardwareapp.security.service.JwtService;
import io.jsonwebtoken.Jwt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
@ContextConfiguration
class HardwareControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HardwareService hardwareService;

    @Test
    void getAllHardware_empty() throws Exception {

        when(hardwareService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(
                get("/hardware")
                .with(
                        user("test").password("test").roles("ADMIN")
                )
                .with(csrf())
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(0)));


    }


}