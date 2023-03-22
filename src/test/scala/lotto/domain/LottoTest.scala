package lotto.domain

import org.scalatest.funsuite.AnyFunSuite

class LottoTest extends AnyFunSuite{

    test("로또는 6개의 숫자로 구성되어야 합니다.") {
        assert(Lotto.issueLotto().numbers.length == 6)
        assertThrows[IllegalArgumentException](Lotto(1, 2, 3, 4, 5))
    }

    test("로또는 중복된 숫자가 들어갈 수 없습니다.") {
        assertThrows[IllegalArgumentException](Lotto(1, 1, 3, 4, 5, 6))
    }

    test("하나라도 범위 바깥의 숫자가 들어가면 LottoNumber 클래스 생성시에 오류가 발생합니다/") {
        assertThrows[IllegalArgumentException](Lotto(1, 1, 3, 4, 5, 99))
    }

}
