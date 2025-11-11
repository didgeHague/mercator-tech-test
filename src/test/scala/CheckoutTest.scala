import Fruit.{Apple, Orange}

class CheckoutTest extends munit.FunSuite {
  test("checkout with different values") {
    val total = Checkout.scan(List("Apple", "Orange", "oRange", "apple", null, "Duff"))
    assertEquals(total, 110)
  }

  test("checkout with no values") {
    val total = Checkout.scan(List())
    assertEquals(total, 0)
  }

  test("checkout with null value") {
    val total = Checkout.scan(null)
    assertEquals(total, 0)
  }

  test("apply offer 3 for 2") {
    val total = Checkout.applyOffer(Orange, 3, 3, 1)
    assertEquals(total, 2 * Orange.getPrice)
  }

  test("apply offer 3 for 2 with extra fruit") {
    val total = Checkout.applyOffer(Orange, 4, 3, 1)
    assertEquals(total, 3 * Orange.getPrice)
  }
  
  test("apply offer 3 for 2 with 2 extra fruit") {
    val total = Checkout.applyOffer(Orange, 5, 3, 1)
    assertEquals(total, 4 * Orange.getPrice)
  }

  test("apply offer 3 for 2 with double the needed") {
    val total = Checkout.applyOffer(Orange, 6, 3, 1)
    assertEquals(total, 4 * Orange.getPrice)
  }

  test("apply offer buy one get one free") {
    val total = Checkout.applyOffer(Apple, 2, 2, 1)
    assertEquals(total, Apple.getPrice)
  }

  test("apply offer buy one get one free with extra fruit") {
    val total = Checkout.applyOffer(Apple, 3, 2, 1)
    assertEquals(total, 2 * Apple.getPrice)
  }

  test("apply offer buy one get one free with double the fruit needed") {
    val total = Checkout.applyOffer(Apple, 4, 2, 1)
    assertEquals(total, 2 * Apple.getPrice)
  }
}
