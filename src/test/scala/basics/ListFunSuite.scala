package basics

import org.scalatest.FunSuite

class ListFunSuite extends FunSuite {

  test("An empty List should have size 0") {
    assert(List.empty.size == 0)
  }

}
