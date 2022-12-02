package Item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasItemTest {
    Item item = new Item("+5 Dexterity Vest", 10, 20);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    @Test
    public void Sulfuras_아이템은_퀄리티와_유통기한_모두_절대_변하지_않습니다() {
        item.setName("Sulfuras, Hand of Ragnaros");
        item.setQuality(10);
        item.setSellIn(10);

        gildedRose.updateQuality();

        assertEquals(10, item.getQuality());
        assertEquals(10, item.getSellIn());
    }

    @Test
    public void Sulfuras_아이템의_퀄리티는_0에서_50제한과_상관없이_변하지_않습니다() {
        item.setName("Sulfuras, Hand of Ragnaros");
        item.setQuality(80);
        item.setSellIn(-1);

        gildedRose.updateQuality();

        assertEquals(80, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }
}
