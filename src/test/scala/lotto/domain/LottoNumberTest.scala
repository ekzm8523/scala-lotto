package lotto.domain

import org.scalatest.funsuite.AnyFunSuite
class LottoNumberTest extends AnyFunSuite{

    test("로또 숫자는 1~45 사이의 값을 갖는다.") {
        (1 to 45).map(num => assert(num == LottoNumber(num).number))
        assertThrows[IllegalArgumentException](LottoNumber(0))
        assertThrows[IllegalArgumentException](LottoNumber(46))
    }

    test("로또 숫자는 정적 팩토리 메소드를 통해 같은 숫자는 항상 같은 객체를 반환한다.") {
        val num = LottoNumber(1)
        val sameNum = LottoNumber(1)
        assert(num eq sameNum)
    }

    test("일반 호출로 부르게 된다면 다른 객체를 반환한다.") {
        val num = new LottoNumber(1)
        val sameNum = new LottoNumber(1)
        assert(!(num eq sameNum))
    }
}
