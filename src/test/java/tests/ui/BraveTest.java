package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import pages.BravePage;

import tests.ui.base.BaseUiTest;

public class BraveTest extends BaseUiTest {
    @Tag("ui")
    @Test
    public void testSearchBrave() {
        BravePage bravePage = new BravePage();
        bravePage.openUrl("https://search.brave.com/");
        bravePage.search("Hello world!");
        //    Assertions.assertTrue(bravePage.isSearchSuccessful());
    }
}
