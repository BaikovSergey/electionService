package ru.cikrf.election.utils;

import ru.cikrf.election.model.Candidate;
import ru.cikrf.election.model.ElectionProtocol;

import java.util.List;

public interface Calculation {
    void calculatePercent(ElectionProtocol protocol, List<Candidate> candidates);
}
