package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    Job test_job1;
    Job test_job2;
    Job constructor_test_job;
    Job equality_job1;
    Job equality_job2;
    Job toString_job;

    @Before
    public void createJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
        constructor_test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        equality_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        equality_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        toString_job = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"),
                new CoreCompetency("Taste"));
    }

    @Test //Test that the ID values for both test objects are unique and differ by 1
    public void jobClassIdsAreUnique() {
        int job1Id = test_job1.getId();
        int job2Id = test_job2.getId();
        int difference = job2Id - job1Id;

        assertEquals(1, job1Id, 0.0001);
        assertEquals(2, job2Id, 0.0001);
        assertEquals(1, difference, 1);
    }

    @Test //Test that all six fields in Job class have correctly set classes and values
    public void testJobConstructorSetsAllFields() {
        assertTrue(Integer.class.isInstance(constructor_test_job.getId()));
        assertEquals(3, constructor_test_job.getId());

        assertTrue(constructor_test_job.getName() instanceof String);
        assertEquals("Product tester", constructor_test_job.getName());

        assertTrue(constructor_test_job.getEmployer() instanceof Employer);
        assertEquals("ACME", constructor_test_job.getEmployer().getValue());

        assertTrue(constructor_test_job.getLocation() instanceof Location);
        assertEquals("Desert", constructor_test_job.getLocation().getValue());

        assertTrue(constructor_test_job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", constructor_test_job.getPositionType().getValue());

        assertTrue(constructor_test_job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", constructor_test_job.getCoreCompetency().getValue());

    }

    @Test //Test that two Job objects are not equal despite having same constructor values
    public void testJobsForEquality() {
        assertFalse(equality_job1.equals(equality_job2));
    }

    @Test //Test that when passed a Job object, returns a string w/blank line before and after job information
    public void testJobReturnsStringWithBlankLines() {
        char[] toStringChars = toString_job.toString().toCharArray();
        int lastChar = toStringChars.length - 1;

        assertEquals("\n", Character.toString(toStringChars[0]));
        assertEquals("\n", Character.toString(toStringChars[lastChar]));
    }

    @Test //Test that string should contain label for each field, followed by data stored in that field
    public void testJobContainsLabelsAndDataOnOwnLines() {

        String output = "\n" +
                "ID: 6\n" +
                "Name: Ice cream taster\n" +
                "Employer: Data not available.\n" +
                "Location: Home\n" +
                "Position Type: UX\n" +
                "Core Competency: Taste\n";

        assertEquals(output, toString_job.toString());
    }

    @Test //Test that if a field is empty, inputs "Data not available." after label
    public void testJobAccountsForEmptyFields() {
        assertTrue(toString_job.toString().contains("Employer: Data not available."));
        assertFalse(toString_job.toString().contains("Name: Data not available."));
    }

//    //Bonus
//    @Test //Test for if a job ONLY contains Id field, returns "OOPS! This job does not seem to exist."
//    public void testJobAccountsForNoFieldsButId() {
//        assertEquals("OOPS! This job does not seem to exist.", test_job1.toString());
//    }

}
