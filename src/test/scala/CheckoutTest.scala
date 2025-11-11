class CheckoutTest extends munit.FunSuite {
  test("checkout with different values") {
    val total = Checkout.scan(List("Apple", "Orange", "oRange", "apple", null, "Duff"))
    assertEquals(total, 200)
  }

  test("checkout with no values") {
    val total = Checkout.scan(List())
    assertEquals(total, 0)
  }

  test("checkout with null value") {
    val total = Checkout.scan(null)
    assertEquals(total, 0)
  }
}
