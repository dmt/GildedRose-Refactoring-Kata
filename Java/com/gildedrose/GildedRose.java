package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isSulfuras(item)) {
                continue;
            }

            item.sellIn = item.sellIn - 1;
            updateQualityOnItem(item);
        }
    }

    public void updateQualityOnItem(Item item) {

        if (itemDegradesInQuality(item)) {
            subtractQuality(item);
            if (item.sellIn < 0) {
                subtractQuality(item);
            }
        } else {
            if (item.sellIn < 0) {
                increaseQualityToMax50(item);
            }
        }


        if (item.name.equals("Aged Brie")) {
            increaseQualityToMax50(item);

        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityToMax50(item);
            if (item.sellIn < 10) {
                increaseQualityToMax50(item);
                if (item.sellIn < 5) {
                    increaseQualityToMax50(item);
                }
            }

        }


        if (item.sellIn < 0 && item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        }

    }

    private boolean itemDegradesInQuality(Item item) {
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQualityToMax50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void subtractQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
