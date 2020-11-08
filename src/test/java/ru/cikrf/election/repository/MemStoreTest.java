package ru.cikrf.election.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.cikrf.election.model.Candidate;
import ru.cikrf.election.model.ElectionProtocol;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemStoreTest {

    private final MemStore store = new MemStore();

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
    public void whenAddProtocolThenOneProtocolInStore() {
        int id = this.store.create(protocol).getId();
        List<ElectionProtocol> result = new ArrayList<>(this.store.findAll());
        this.store.delete(id);
        assertEquals(1, result.size());
    }

    @Test
    public void whenProtocolAddedThenPercentOfVotesCalculated() {
        int id = this.store.create(protocol).getId();
        List<ElectionProtocol> result = new ArrayList<>(this.store.findAll());
        double percentOfTotalVotes = result.get(0).getCandidates().get(0).getPercentOfTotal();
        this.store.delete(id);
        assertEquals(33.34d, percentOfTotalVotes);
    }

}