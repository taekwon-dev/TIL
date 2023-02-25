package com.youn.message_converter.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ControllerV2.class)
class ControllerV2Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("[Object Mapper] 기본 생성자 없이 역직렬화 시도")
    void readValueWithoutDefaultConstructor() {
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = "{\"age\":20,\"name\":\"TK\"}\n";
        assertThatThrownBy(() -> mapper.readValue(requestBody, RequestDtoV2.class))
                .isInstanceOf(JsonMappingException.class);
    }

    @Test
    @DisplayName("[Object Mapper] jackson-module-parameter-names 모듈 추가 후 역직렬화 시도")
    void readValueWithoutDefaultConstructorAddedJacksonModule() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParameterNamesModule());
        String requestBody = "{\"age\":20,\"name\":\"TK\"}\n";

        RequestDtoV2 requestDtoV2 = mapper.readValue(requestBody, RequestDtoV2.class);

        assertThat(requestDtoV2.getAge()).isEqualTo(20);
        assertThat(requestDtoV2.getName()).isEqualTo("TK");
    }

    @Test
    @DisplayName("[MockMVC] POST Request 테스트")
    void mockMVCTestWithoutDefaultConstructor() throws Exception {
        String requestBody = "{\"age\":20,\"name\":\"TK\"}\n";
        mockMvc.perform(post("/v2/request-body")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody))
                .andExpect(status().isOk())
                .andDo(print());
    }
}