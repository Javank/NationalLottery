package com.devskiller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExerciseTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldReturnListWithRepeatedValues() {
        // given
        Exercise exercise = new Exercise();

        // when
        List<Integer> result = exercise.findDuplicates(asList(-1, 1, 3, 2, 5, 6, -1, 3, 6), 2);

        // then
        assertThat(asList(-1, 3, 6), containsInAnyOrder(result.toArray()));
    }

    @Test
    public void nullValuesShouldBeOmitted() {
        // given
        Exercise exercise = new Exercise();

        // when
        List<Integer> result = exercise.findDuplicates(asList(1, 1, null, 2, 5, 6, 1, 3, 6, null), 2);

        // then
        assertEquals(singletonList(6), result);
    }

    @Test
    public void shouldReturnListWithNumberOfDuplicatesOne() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Duplicate can be only found for two or more elements");

        // given
        Exercise exercise = new Exercise();

        // when
        exercise.findDuplicates(asList(-1, 1, 3, 2, 5, 6, -1, 3, 6), 1);
    }

    @Test
    public void shouldReturnListEmpty() {
        // given
        Exercise exercise = new Exercise();

        // when
        List<Integer> result = exercise.findDuplicates(asList(-1, 1, 3, 2, 5, 6, -1, 3, 6), 3);

        // then
        assertThat(asList(), containsInAnyOrder(result.toArray()));
    }

    @Test
    public void shouldReturnListWithNumberOfDuplicatesThree() {
        // given
        Exercise exercise = new Exercise();

        // when
        List<Integer> result = exercise.findDuplicates(asList(-1, -1, 3, 2, 5, 6, -1, 3, 6), 3);

        // then
        assertThat(asList(-1), containsInAnyOrder(result.toArray()));
    }

}
