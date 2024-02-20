package ru.job4j.collection.job;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class JobTest {

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpName = new AscByName();
        int rsl = cmpName.compare(
                new Job("Abstract task", 0),
                new Job("Bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpName = new DescByName();
        int rsl = cmpName.compare(
                new Job("Abstract task", 0),
                new Job("Bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmpName = new AskByPriority();
        int rsl = cmpName.compare(
                new Job("Abstract task", 0),
                new Job("Bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpName = new DescByPriority();
        int rsl = cmpName.compare(
                new Job("Abstract task", 0),
                new Job("Bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new DescByName().thenComparing(new DescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareAndSortByPriorityAndName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Annoying bug", 2),
                new Job("Fix bug", 4),
                new Job("Annoying bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        jobs.sort(new AskByPriority().thenComparing(new AscByName()));
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug", 1),
                new Job("Annoying bug", 2),
                new Job("Fix bug", 2),
                new Job("Annoying bug", 4),
                new Job("Fix bug", 4)
        );
        assertThat(jobs.toString()).isEqualTo(expected.toString());
    }

    @Test
    public void whenCompareAndSortDescByPriorityAndName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("Annoying bug", 2),
                new Job("X task", 0)
        );
        jobs.sort(new DescByPriority().thenComparing(new AscByName()));
        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 4),
                new Job("Annoying bug", 2),
                new Job("Fix bug", 2),
                new Job("Fix bug", 1),
                new Job("X task", 0)
        );
        assertThat(jobs.toString()).isEqualTo(expected.toString());
    }
}