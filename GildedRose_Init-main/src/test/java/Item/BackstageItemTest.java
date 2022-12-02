package Item;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstageItemTest {
    Item item = new Item("+5 Dexterity Vest", 10, 20);
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_10일보다_많이_남으면_1씩_증가합니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(10);
        item.setSellIn(11);

        gildedRose.updateQuality();

        assertEquals(11, item.getQuality());
        assertEquals(10, item.getSellIn());
    }

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_10일보다_많아도_50을_넘을_수_없습니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(50);
        item.setSellIn(11);

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
        assertEquals(10, item.getSellIn());
    }

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_5일_초과_10일_이하로_남으면_2씩_증가합니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(10);
        item.setSellIn(10);

        gildedRose.updateQuality();

        assertEquals(12, item.getQuality());
        assertEquals(9, item.getSellIn());
    }

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_5일_초과_10일_이하로_남아도_50을_넘을_수_없습니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(49);
        item.setSellIn(10);

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
        assertEquals(9, item.getSellIn());
    }

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_1일_이상_5일_이하로_남으면_3씩_증가합니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(10);
        item.setSellIn(5);

        gildedRose.updateQuality();

        assertEquals(13, item.getQuality());
        assertEquals(4, item.getSellIn());
    }

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_1일이상_5일이하로_남아도_퀄리티는_50을_넘을_수는_없습니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(48);
        item.setSellIn(5);

        gildedRose.updateQuality();

        assertEquals(50, item.getQuality());
        assertEquals(4, item.getSellIn());
    }

    @Test
    public void Backstage_아이템의_퀄리티는_유통기한이_지나면_0이_됩니다() {
        item.setName("Backstage passes to a TAFKAL80ETC concert");
        item.setQuality(10);
        item.setSellIn(0);

        gildedRose.updateQuality();

        assertEquals(0, item.getQuality());
        assertEquals(-1, item.getSellIn());
    }
}