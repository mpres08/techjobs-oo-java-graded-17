package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality Control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality Control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String newLine = System.lineSeparator();
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality Control"), new CoreCompetency("Persistence"));
        String expectedOutput = newLine +
                "ID: 1\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality Control\n" +
                "Core Competency: Persistence" +
                newLine;

        assertEquals(expectedOutput, testJob.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String newLine = System.lineSeparator();
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality Control"), new CoreCompetency("Persistence"));
        String expectedOutput = newLine + "ID: " + job1.getId() + newLine +
                "Name: Product tester" + newLine +
                "Employer: ACME" + newLine +
                "Location: Desert" + newLine +
                "Position Type: Quality Control" + newLine +
                "Core Competency: Persistence" + newLine;

        assertEquals(expectedOutput, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String newLine = System.lineSeparator();
        Job job1 = new Job("", new Employer(""), new Location(""),
                new PositionType(
                ""), new CoreCompetency(""));
        String expectedOutput = newLine + "ID: " + job1.getId() + newLine +
                "Name: Data not available" + newLine +
                "Employer: Data not available" + newLine +
                "Location: Data not available" + newLine +
                "Position Type: Data not available" + newLine +
                "Core Competency: Data not available" + newLine;

        assertEquals(expectedOutput, job1.toString());
    }
}
