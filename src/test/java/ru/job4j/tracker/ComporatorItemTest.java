package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComporatorItemTest {
    @Test
    void sortItems() {
        List<Item> items = Arrays.asList(
                new Item("one"),
                new Item("two"),
                new Item("three"),
                new Item("four"),
                new Item("five")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("five"),
                new Item("four"),
                new Item("one"),
                new Item("three"),
                new Item("two")
        );
    Assert.assertEquals(items, expected);
    }

    @Test
    void sortDiscItems() {
        List<Item> items = Arrays.asList(
                new Item("one"),
                new Item("two"),
                new Item("three"),
                new Item("four"),
                new Item("five")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("two"),
                new Item("three"),
                new Item("one"),
                new Item("four"),
                new Item("five")
        );
        Assert.assertEquals(items, expected);
    }
}
