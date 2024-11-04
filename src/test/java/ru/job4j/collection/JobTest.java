package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpName = new JobByName();
        int rsl = cmpName.compare(
                new Job("Volvo", 0),
                new Job("Lada", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 7),
                new Job("Fix bug", 4)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("S", 0),
                new Job("S", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndPriority() {
        Comparator<Job> cmpDescNamePriority = new JobDescByName().thenComparing(new JobByPriority());
        int rsl = cmpDescNamePriority.compare(
                new Job("P", 0),
                new Job("s", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndDescPriority() {
        Comparator<Job> cmpNameDescPriority = new JobByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNameDescPriority.compare(
                new Job("z", 3),
                new Job("X", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpDescNameDescPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNameDescPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }
}
