package com.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    private GildedRose gildedRose;

    @Before
    public void setUp() throws Exception {
        gildedRose = new GildedRose(new Item[]{});
    }

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void agedBrieIncreasesInQuality() throws Exception {
        Item brie = new Item("Aged Brie", 5, 1);
        gildedRose.updateQualityOnItem(brie);

        assertTrue(brie.quality > 1);

    }

    @Test
    public void defaultItemsDecreaseInQuality() throws Exception {
        Item someItem = new Item("Some Item", 5, 2);

        gildedRose.updateQualityOnItem(someItem);

        assertEquals(1, someItem.quality);

    }
}
