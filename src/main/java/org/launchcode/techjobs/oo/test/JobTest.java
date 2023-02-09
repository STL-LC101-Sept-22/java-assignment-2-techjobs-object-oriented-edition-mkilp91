package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)


public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob3;
    Job testJob4;
    Job testJob5;
    Job testJob6;
    @Before
    public void createTestData(){
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3 = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        testJob4 = new Job();
        testJob5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        testJob6 = new Job(null, new Employer(null), new Location(null), new PositionType(null), new CoreCompetency(null));

    }

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job fTestJob = testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job fTestJob2 = new Job(null, new Employer(null), new Location(null), new PositionType(null), new CoreCompetency(null));

        String t1Name = fTestJob.getName();
        String t1EmployerVal = fTestJob.getEmployer().getValue();
        String t1LocationVal = fTestJob.getLocation().getValue();
        String t1PTVal = fTestJob.getPositionType().getValue();
        String t1CCVal = fTestJob.getCoreCompetency().getValue();

        assertEquals("Product tester", t1Name);
        assertEquals("ACME", t1EmployerVal);
        assertEquals("Desert", t1LocationVal);
        assertEquals("Quality control", t1PTVal);
        assertEquals("Persistence", t1CCVal);

        assertEquals("", fTestJob2.getName());
        assertEquals("", fTestJob2.getEmployer().getValue());
        assertEquals("", fTestJob2.getLocation().getValue());
        assertEquals("", fTestJob2.getPositionType().getValue());
        assertEquals("", fTestJob2.getCoreCompetency().getValue());

        assertTrue(fTestJob.getName() instanceof String);
        assertTrue(fTestJob.getEmployer() instanceof Employer);
        assertTrue(fTestJob.getLocation() instanceof Location);
        assertTrue(fTestJob.getPositionType() instanceof PositionType);
        assertTrue(fTestJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job eTestJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job eTestJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(eTestJob1.equals(eTestJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job charTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', charTestJob.toString().charAt(0));
        assertEquals('\n', charTestJob.toString().charAt(charTestJob.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job lDTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        Labels:
        assertTrue(lDTestJob.toString().contains("ID: "));
        assertTrue(lDTestJob.toString().contains("Name: "));
        assertTrue(lDTestJob.toString().contains("Employer: "));
        assertTrue(lDTestJob.toString().contains("Position Type: "));
        assertTrue(lDTestJob.toString().contains("Core Competency: "));

//        Data:
        assertTrue(lDTestJob.toString().contains("Product tester"));
        assertTrue(lDTestJob.toString().contains("ACME"));
        assertTrue(lDTestJob.toString().contains("Desert"));
        assertTrue(lDTestJob.toString().contains("Quality control"));
        assertTrue(lDTestJob.toString().contains("Persistence"));

        assertEquals(
                "\nID: "+ lDTestJob.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", lDTestJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job tSJob1 =new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Job tSJob2 = new Job();
        assertTrue(tSJob1.toString().contains("Data not available"));
        assertTrue(tSJob2.toString().contains("OOPS! This job does not seem to exist"));
        assertEquals("\nID: " + tSJob1.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + "Data not available" +
                "\n", tSJob1.toString());
    }
}
