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
    @Before
    public void createTestData(){
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3 = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        testJob4 = new Job();
        testJob5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

    }

    @Test
    public void testSettingJobID(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", testJob1.getName());
        assertEquals("ACME", testJob1.getEmployer().getValue());
        assertEquals("Desert", testJob1.getLocation().getValue());
        assertEquals("Quality control", testJob1.getPositionType().getValue());
        assertEquals("Persistence", testJob1.getCoreCompetency().getValue());

        assertTrue(testJob1.getName() instanceof String);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(testJob1.equals(testJob2));
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
