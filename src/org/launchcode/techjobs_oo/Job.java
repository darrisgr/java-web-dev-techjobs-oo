package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
        this.name = "";
        this.employer = new Employer("");
        this.location = new Location("");
        this.positionType = new PositionType("");
        this.coreCompetency = new CoreCompetency("");
    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
                CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String firstLineBreak = "\n";
        String lastLineBreak = "\n";
        String lineBreak = "\n";
        String nameInput;
        String employerInput;
        String locationInput;
        String positionTypeInput;
        String coreCompetencyInput;
        boolean noName = false;
        boolean noEmployer = false;
        boolean noLocation = false;
        boolean noPosition = false;
        boolean noCore = false;

        if (this.name.equals("")) {
            noName = true;
            nameInput = "Data not available.";
        } else {
            nameInput = this.getName();
        }

        if (this.employer.toString().equals("")) {
            noEmployer = true;
            employerInput = "Data not available.";
        } else {
            employerInput = this.employer.toString();
        }

        if (this.location.toString().equals("")) {
            noLocation = true;
            locationInput = "Data not available.";
        } else {
            locationInput = this.location.toString();
        }

        if (this.positionType.toString().equals("")) {
            noPosition = true;
            positionTypeInput = "Data not available.";
        } else {
            positionTypeInput = this.positionType.toString();
        }

        if (this.coreCompetency.toString().equals("")) {
            noCore = true;
            coreCompetencyInput = "Data not available.";
        } else {
            coreCompetencyInput = this.coreCompetency.toString();
        }

        if (noName && noEmployer && noLocation && noPosition && noCore) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return firstLineBreak + "ID: " + this.getId() +
                    lineBreak + "Name: " + nameInput +
                    lineBreak + "Employer: " + employerInput +
                    lineBreak + "Location: " + locationInput +
                    lineBreak + "Position Type: " + positionTypeInput +
                    lineBreak + "Core Competency: " + coreCompetencyInput + lastLineBreak;
        }

    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
