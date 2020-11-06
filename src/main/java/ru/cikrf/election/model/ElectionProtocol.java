package ru.cikrf.election.model;


import java.util.List;
import java.util.Objects;

public class ElectionProtocol {

    private int id;
    private String electionName;
    private String date;
    private int totalVoters;
    private int precinctBulletins;
    private int aheadOfScheduleBulletins;
    private int indoorsBulletins;
    private int outsidesBulletins;
    private int canceledBulletins;
    private int mobileBoxesBulletins;
    private int staticBoxesBulletins;
    private int invalidBulletins;
    private int validBulletins;
    private int lostBulletins;
    private int unaccountedBulletins;
    private List<Candidate> candidates;

    public ElectionProtocol(String electionName, String date, int totalVoters, int precinctBulletins, int aheadOfScheduleBulletins, int indoorsBulletins, int outsidesBulletins, int canceledBulletins, int mobileBoxesBulletins, int staticBoxesBulletins, int invalidBulletins, int validBulletins, int lostBulletins, int unaccountedBulletins, List<Candidate> candidates) {
        this.electionName = electionName;
        this.date = date;
        this.totalVoters = totalVoters;
        this.precinctBulletins = precinctBulletins;
        this.aheadOfScheduleBulletins = aheadOfScheduleBulletins;
        this.indoorsBulletins = indoorsBulletins;
        this.outsidesBulletins = outsidesBulletins;
        this.canceledBulletins = canceledBulletins;
        this.mobileBoxesBulletins = mobileBoxesBulletins;
        this.staticBoxesBulletins = staticBoxesBulletins;
        this.invalidBulletins = invalidBulletins;
        this.validBulletins = validBulletins;
        this.lostBulletins = lostBulletins;
        this.unaccountedBulletins = unaccountedBulletins;
        this.candidates = candidates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalVoters() {
        return totalVoters;
    }

    public void setTotalVoters(int totalVoters) {
        this.totalVoters = totalVoters;
    }

    public int getPrecinctBulletins() {
        return precinctBulletins;
    }

    public void setPrecinctBulletins(int precinctBulletins) {
        this.precinctBulletins = precinctBulletins;
    }

    public int getAheadOfScheduleBulletins() {
        return aheadOfScheduleBulletins;
    }

    public void setAheadOfScheduleBulletins(int aheadOfScheduleBulletins) {
        this.aheadOfScheduleBulletins = aheadOfScheduleBulletins;
    }

    public int getIndoorsBulletins() {
        return indoorsBulletins;
    }

    public void setIndoorsBulletins(int indoorsBulletins) {
        this.indoorsBulletins = indoorsBulletins;
    }

    public int getOutsidesBulletins() {
        return outsidesBulletins;
    }

    public void setOutsidesBulletins(int outsidesBulletins) {
        this.outsidesBulletins = outsidesBulletins;
    }

    public int getCanceledBulletins() {
        return canceledBulletins;
    }

    public void setCanceledBulletins(int canceledBulletins) {
        this.canceledBulletins = canceledBulletins;
    }

    public int getMobileBoxesBulletins() {
        return mobileBoxesBulletins;
    }

    public void setMobileBoxesBulletins(int mobileBoxesBulletins) {
        this.mobileBoxesBulletins = mobileBoxesBulletins;
    }

    public int getStaticBoxesBulletins() {
        return staticBoxesBulletins;
    }

    public void setStaticBoxesBulletins(int staticBoxesBulletins) {
        this.staticBoxesBulletins = staticBoxesBulletins;
    }

    public int getInvalidBulletins() {
        return invalidBulletins;
    }

    public void setInvalidBulletins(int invalidBulletins) {
        this.invalidBulletins = invalidBulletins;
    }

    public int getValidBulletins() {
        return validBulletins;
    }

    public void setValidBulletins(int validBulletins) {
        this.validBulletins = validBulletins;
    }

    public int getLostBulletins() {
        return lostBulletins;
    }

    public void setLostBulletins(int lostBulletins) {
        this.lostBulletins = lostBulletins;
    }

    public int getUnaccountedBulletins() {
        return unaccountedBulletins;
    }

    public void setUnaccountedBulletins(int unaccountedBulletins) {
        this.unaccountedBulletins = unaccountedBulletins;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectionProtocol protocol = (ElectionProtocol) o;
        return id == protocol.id &&
                totalVoters == protocol.totalVoters &&
                precinctBulletins == protocol.precinctBulletins &&
                aheadOfScheduleBulletins == protocol.aheadOfScheduleBulletins &&
                indoorsBulletins == protocol.indoorsBulletins &&
                outsidesBulletins == protocol.outsidesBulletins &&
                canceledBulletins == protocol.canceledBulletins &&
                mobileBoxesBulletins == protocol.mobileBoxesBulletins &&
                staticBoxesBulletins == protocol.staticBoxesBulletins &&
                invalidBulletins == protocol.invalidBulletins &&
                validBulletins == protocol.validBulletins &&
                lostBulletins == protocol.lostBulletins &&
                unaccountedBulletins == protocol.unaccountedBulletins &&
                Objects.equals(electionName, protocol.electionName) &&
                Objects.equals(date, protocol.date) &&
                Objects.equals(candidates, protocol.candidates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, electionName, date, totalVoters, precinctBulletins, aheadOfScheduleBulletins, indoorsBulletins, outsidesBulletins, canceledBulletins, mobileBoxesBulletins, staticBoxesBulletins, invalidBulletins, validBulletins, lostBulletins, unaccountedBulletins, candidates);
    }
}
