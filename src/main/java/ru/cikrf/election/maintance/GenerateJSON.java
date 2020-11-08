package ru.cikrf.election.maintance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.cikrf.election.model.Candidate;
import ru.cikrf.election.model.ElectionProtocol;
import java.util.ArrayList;
import java.util.List;

public class GenerateJSON {

    public static void main(String[] args) {
        ElectionProtocol protocol = new ElectionProtocol(
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
        Candidate first = new Candidate("Первый", "Кандидат",
                "", 30);
        Candidate second = new Candidate("Второй", "Кандидат",
                "", 60);
        list.add(first);
        list.add(second);
        protocol.setCandidates(list);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(protocol);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
