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
        assertEquals('\n', testJob1.toString().charAt(0));
        assertEquals('\n', testJob1.toString().charAt(testJob1.toString().length()-1));
    }

    @Test
    public void testTOStringContainsCorrectLabelsAndData(){
//        Labels:
        assertTrue(testJob1.toString().contains("ID: "));
        assertTrue(testJob1.toString().contains("Name: "));
        assertTrue(testJob1.toString().contains("Employer: "));
        assertTrue(testJob1.toString().contains("Position Type: "));
        assertTrue(testJob1.toString().contains("Core Competency: "));

//        Data:
        assertTrue(testJob1.toString().contains("Product tester"));
        assertTrue(testJob1.toString().contains("ACME"));
        assertTrue(testJob1.toString().contains("Desert"));
        assertTrue(testJob1.toString().contains("Quality control"));
        assertTrue(testJob1.toString().contains("Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        assertTrue(testJob3.toString().contains("Data not available"));
        assertTrue(testJob5.toString().contains("OOPS! This job does not seem to exist"));
    }
}
