package com.gildedrose;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class GildedRoseTest {
    private Item[] items;
    private GildedRose app;

    @BeforeEach
    public void setUp() {
        this.items = new Item[]{
                new Item("foo", 1, 10),
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6),
                new Item("Conjured Mana Cake", 3, 20)
        };
        this.app = new GildedRose(items);
    }

    @AfterEach
    public void tearDown() {
        if (this.items != null) {
            this.items = null;
        }
        if (this.app != null) {
            this.app = null;
        }
    }

    @Test
    public void foo() {
        app.updateQuality();

        assertEquals("foo", items[0].name);
        assertEquals(0, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    @Test
    @DisplayName("Queijo “Aged Brie” aumenta de qualidade até no máximo 50")
    public void agedBrieAumentaQualidadeAte50() {
        Item agedBrie = items[2];

        assertTrue(agedBrie.quality < 50);
        for (int i = 1; i <= 100; i++) {
            app.updateQuality();
        }
        assertEquals(50, agedBrie.quality);
    }

    @Test
    @DisplayName("Sulfuras não sofrem alterações")
    public void sulfurasNaoSofreAlteracao() {
        Item sulfuras1 = items[4];
        Item sulfuras2 = items[5];

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras1.name);
        assertEquals(0, sulfuras1.sellIn);
        assertEquals(80, sulfuras1.quality);

        assertEquals("Sulfuras, Hand of Ragnaros", sulfuras2.name);
        assertEquals(-1, sulfuras2.sellIn);
        assertEquals(80, sulfuras2.quality);
    }

    @Test
    @DisplayName("Backstage Pass zera a qualidade após a data de venda")
    public void backstagePassZeraQualidadeAposDataDeVenda() {
        Item backstagePass1 = items[6];
        Item backstagePass2 = items[7];
        Item backstagePass3 = items[8];

        for (int i = 1; i <= 100; i++) {
            app.updateQuality();
        }

        assertEquals(0, backstagePass1.quality);
        assertEquals(0, backstagePass2.quality);
        assertEquals(0, backstagePass3.quality);
    }

    @Test
    @DisplayName("Conjured perde qualidade 2x mais rápido")
    public void conjuredPerdeQualidadeDuasVezesMaisRapido() {
        Item conjured = items[9];

        app.updateQuality();

        assertEquals("Conjured Mana Cake", conjured.name);
        assertEquals(2, conjured.sellIn);
        assertEquals(4, conjured.quality);
    }

    @Test
    @DisplayName("Conjured perde qualidade 4x mais rápido após data de venda")
    public void conjuredPerdeQualidadeQuatroVezesMaisRapidoAposDataDeVenda() {
        Item conjured = items[10];

        while (conjured.sellIn >= 0) {
            app.updateQuality();
        }

        assertEquals("Conjured Mana Cake", conjured.name);
        assertTrue(conjured.sellIn < 0);
        assertEquals(10, conjured.quality);
    }
}
