package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void qualityIsNeverNegative() {
        Item item = new Item("name", 2, -1);

        assertEquals(0, item.quality);
    }

}
