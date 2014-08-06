package org.ave.pet.sport;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BeachSportTest {

    @Test
    public void testAvailableBorads() {
        // GIVEN - WHEN
        BeachSport beachSport = new BeachSport();

        // THEN
        assertNotNull(beachSport.getBoards());
        System.out.println("BeachSport TEST is finished successfully.");
    }

}
