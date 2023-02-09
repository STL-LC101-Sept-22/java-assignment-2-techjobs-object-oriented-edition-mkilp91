package org.launchcode.techjobs.oo;

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

    public Job(){
        this.id = nextId;
        nextId++;

        if (this.name == null) {
            this.name = "";
        }

        if (this.employer == null){
            this.employer = new Employer("");
        }

        if (this.employer.getValue() == null) {
            this.employer.setValue("");
        }

        if (this.location == null){
            this.location = new Location("");
        }

        if (this.location.getValue() == null) {
            this.location.setValue("");
        }

        if (this.positionType == null){
            this.positionType = new PositionType("");
        }

        if (this.positionType.getValue() == null) {
            this.positionType.setValue("");
        }

        if (this.coreCompetency == null){
            this.coreCompetency = new CoreCompetency("");
        }

        if (this.coreCompetency.getValue() == null) {
            this.coreCompetency.setValue("");
        }
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency){
        this();

        if (aName == null) {
            aName = "";
        }

        if (aEmployer == null){
            aEmployer = new Employer("");
        }

        if (aEmployer.getValue() == null) {
            aEmployer.setValue("");
        }

        if (aLocation == null){
            aLocation = new Location("");
        }

        if (aLocation.getValue() == null) {
            aLocation.setValue("");
        }

        if (aPositionType == null){
            aPositionType = new PositionType("");
        }

        if (aPositionType.getValue() == null) {
            aPositionType.setValue("");
        }

        if (aCoreCompetency == null){
            aCoreCompetency = new CoreCompetency("");
        }

        if (aCoreCompetency.getValue() == null) {
            aCoreCompetency.setValue("");
        }


        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    @Override
    public String toString() {
        int nullCount = 0;
        String nameVal = "Data not available";
        String employerVal = "Data not available";
        String locationVal = "Data not available";
        String pTVal = "Data not available";
        String cCVal = "Data not available";
        String jobString;

        if (name.equals(null) || name.equals("")){
            nullCount++;
        } else {
            nameVal = getName();
        }

        if (employer.equals(null) || employer.getValue().equals(null) || employer.equals("") || employer.getValue().equals("")){
            nullCount++;
        } else {
        employerVal = employer.getValue();
        }

        if (location.equals(null) || location.getValue().equals(null) || location.equals("") || location.getValue().equals("")){
            nullCount++;
        } else {
            locationVal = location.getValue();

        } if (positionType.equals(null) || positionType.getValue().equals(null) || positionType.equals("") || positionType.getValue().equals("")){
            nullCount++;
        } else {
            pTVal = positionType.getValue();
        }

        if (coreCompetency.equals(null) || coreCompetency.getValue().equals(null) || coreCompetency.equals("") || coreCompetency.getValue().equals("")){
        nullCount++;
        } else {
        cCVal = coreCompetency.getValue();
        }

//        String jobString = "\n" +
//                "ID: " + id + "\n" +
//                "Name: " + nameVal + "\n" +
//                "Employer: " + employerVal + "\n" +
//                "Location: " + location.getValue() + "\n" +
//                "Position Type: " + positionType.getValue() + "\n" +
//                "Core Competency: " + coreCompetency.getValue() +
//                "\n";

//        if (name.equals("") && employer.getValue().equals("") && location.getValue().equals("") && positionType.getValue().equals("") && coreCompetency.getValue().equals("")) {
//        return "OOPS! This job does not seem to exist.";
//        } else {
//
//            if (nameVal.equals("")) {
//                nameVal = "Data not available";
//            }
//            if (employer.getValue().equals("")) {
//                employerVal = "Data not available";
//            }
//            if (location.getValue().equals("")) {
//                locationVal = "Data not available";
//            }
//            if (positionType.getValue().equals("")) {
//                pTVal = "Data not available";
//            }
//            if (coreCompetency.getValue().equals("")) {
//                cCVal = "Data not available";
//            }
//        }
        if (nullCount == 5) {
            jobString = "OOPS! This job does not seem to exist.";
        } else {
            jobString = "\n" +
                    "ID: " + id + "\n" +
                    "Name: " + nameVal + "\n" +
                    "Employer: " + employerVal + "\n" +
                    "Location: " + locationVal + "\n" +
                    "Position Type: " + pTVal + "\n" +
                    "Core Competency: " + cCVal +
                    "\n";
        }
        return jobString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
//        NOT NEEDED: if (!(o instanceof Job)) return false;
//        NOT NEEDED: if (((Job) o).getName() == null || ((Job) o).getEmployer() == null || ((Job) o).getLocation() == null || ((Job) o).getPositionType() == null || ((Job) o).getCoreCompetency() == null) return false;
        Job job = (Job) o;
        if (this.getId() == job.getId()) return true;
        return id == job.id && name.equals(job.name) && employer.equals(job.employer) && location.equals(job.location) && positionType.equals(job.positionType) && coreCompetency.equals(job.coreCompetency);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

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

    public int getId() {
        return id;
    }
}
