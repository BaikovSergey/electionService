package ru.cikrf.election.model;

import java.io.Serializable;
import java.util.Objects;

public class Candidate implements Serializable {

    private String firstName;
    private String secondName;
    private String patronName;
    private int numOfVotes;
    private double percentOfTotal;

    public Candidate() {

    }

    public Candidate(String firstName, String secondName, String patronName, int numOfVotes) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronName = patronName;
        this.numOfVotes = numOfVotes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public int getNumOfVotes() {
        return numOfVotes;
    }

    public void setNumOfVotes(int numOfVotes) {
        this.numOfVotes = numOfVotes;
    }

    public double getPercentOfTotal() {
        return percentOfTotal;
    }

    public void setPercentOfTotal(double percentOfTotal) {
        this.percentOfTotal = percentOfTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return numOfVotes == candidate.numOfVotes &&
                Double.compare(candidate.percentOfTotal, percentOfTotal) == 0 &&
                Objects.equals(firstName, candidate.firstName) &&
                Objects.equals(secondName, candidate.secondName) &&
                Objects.equals(patronName, candidate.patronName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, patronName, numOfVotes, percentOfTotal);
    }
}
