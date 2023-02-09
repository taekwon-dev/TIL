package com.youn.message_converter.v3;

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

@WebMvcTest(controllers = ControllerV3.class)
class ControllerV3Test {

    private static final String REQUEST_BODY = "{\"age\":20,\"name\":\"TK\",\"email\":\"T@K.com\"}\n";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("[Object Mapper] 기본 생성자 없이 역직렬화 시도")
    void readValueWithoutDefaultConstructor() {
        ObjectMapper mapper = new ObjectMapper();
        assertThatThrownBy(() -> mapper.readValue(REQUEST_BODY, RequestDtoV3.class))
                .isInstanceOf(JsonMappingException.class);
    }

    @Test
    @DisplayName("[Object Mapper] jackson-module-parameter-names 모듈 추가 후 역직렬화 시도")
    void readValueWithoutDefaultConstructorAddedJacksonModule() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParameterNamesModule());

        RequestDtoV3 requestDtoV3 = mapper.readValue(REQUEST_BODY, RequestDtoV3.class);

        assertThat(requestDtoV3.getAge()).isEqualTo(20);
        assertThat(requestDtoV3.getName()).isEqualTo("TK");
        assertThat(requestDtoV3.getEmail()).isEqualTo("T@K.com");
    }

    @Test
    @DisplayName("[MockMVC] POST Request 테스트")
    void mockMVCTestWithoutDefaultConstructor() throws Exception {
        mockMvc.perform(post("/v3/request-body")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(REQUEST_BODY))
                .andExpect(status().isOk())
                .andDo(print());
    }
}