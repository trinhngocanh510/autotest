package tests.ui;

import org.junit.jupiter.api.Test;
import pages.BravePage;
import tests.ui.base.BaseTest;

public class BraveTest extends BaseTest {
  @Test
  public void testSearchBrave() {
    BravePage bravePage = new BravePage();
    bravePage.openUrl("https://search.brave.com/");
    bravePage.search("Hello world!");
    //    Assertions.assertTrue(bravePage.isSearchSuccessful());
  }
}
