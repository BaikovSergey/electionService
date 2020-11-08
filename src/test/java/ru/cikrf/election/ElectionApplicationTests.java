package ru.cikrf.election;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.cikrf.election.controller.ElectionProtocolController;
import ru.cikrf.election.model.Candidate;
import ru.cikrf.election.model.ElectionProtocol;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class ElectionApplicationTests {

    @Autowired
    private ElectionProtocolController controller;

    @Autowired
    private MockMvc mockMvc;

    private static ElectionProtocol protocol;

    @BeforeAll
    public static void generateProtocol() {
        protocol = new ElectionProtocol(
                "Test name",
                "01.01.2020",
                100,
                90,
                10,
                30,
                10,
                10,
                10,
                20,
                1,
                80,
                1,
                1,
                new ArrayList<>()
        );
        List<Candidate> list = new ArrayList<>();
        Candidate first = new Candidate("First", "Candidate",
                "", 10);
        Candidate second = new Candidate("Second", "Candidate",
                "", 20);
        list.add(first);
        list.add(second);
        protocol.setCandidates(list);
    }

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/protocols/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testPost() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(protocol);
            this.mockMvc.perform(post("/protocols/").contentType(MediaType.APPLICATION_JSON).content(json))
                    .andDo(print())
                    .andExpect(status().isCreated());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
