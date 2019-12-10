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
        assertNotEquals(job1Id, job2Id);
    }

    @Test //Test that all six fields in Job class are correctly set
    public void testJobConstructorSetsAllFields() {
        assertTrue(constructor_test_job.getName() instanceof String);
        assertTrue(constructor_test_job.getEmployer() instanceof Employer);
        assertTrue(constructor_test_job.getLocation() instanceof Location);
        assertTrue(constructor_test_job.getPositionType() instanceof PositionType);
        assertTrue(constructor_test_job.getCoreCompetency() instanceof CoreCompetency);
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

        assertTrue(toString_job.toString().contains("ID: "));
        assertEquals(6, toString_job.getId());

        assertTrue(toString_job.toString().contains("Name: "));
        assertEquals("Ice cream taster", toString_job.getName());

        assertTrue(toString_job.toString().contains("Employer: "));
        assertEquals("", toString_job.getEmployer().toString());

        assertTrue(toString_job.toString().contains("Location: "));
        assertEquals("Home", toString_job.getLocation().toString());

        assertTrue(toString_job.toString().contains("Position Type: "));
        assertEquals("UX", toString_job.getPositionType().toString());

        assertTrue(toString_job.toString().contains("Core Competency: "));
        assertEquals("Taste", toString_job.getCoreCompetency().toString());
    }

    @Test //Test that if a field is empty, inputs "Data not available." after label
    public void testJobAccountsForEmptyFields() {
        assertTrue(toString_job.toString().contains("Employer: Data not available."));
        assertFalse(toString_job.toString().contains("Name: Data not available."));
    }

    //Bonus
    @Test //Test for if a job ONLY contains Id field, returns "OOPS! This job does not seem to exist."
    public void testJobAccountsForAllEmptyFields() {
        assertEquals("OOPS! This job does not seem to exist.", test_job1.toString());
    }

}
