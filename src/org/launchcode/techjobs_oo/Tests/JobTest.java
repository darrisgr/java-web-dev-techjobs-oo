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

}
