package lotto.domain

import org.scalatest.funsuite.AnyFunSuite
class WinningLottoTest extends AnyFunSuite {

    test("당첨 로또는 apply 메서드 생성 방식과 일반 생성 방식으로 생성할 수 있다.") {
        WinningLotto(List(1, 2, 3, 4, 5, 6), 7)
        new WinningLotto(Lotto(List(1, 2, 3, 4, 5, 6)), LottoNumber(7))
    }

    test("자동 생성된 당첨 로또는 6자리의 숫자와 겹치지 않는 보너스 숫자로 구성되어 있다.") {
        val winningLotto = WinningLotto.generate()
        val numberSet = winningLotto.lotto.numbers.toSet
        assert(numberSet.size == 6)
        assert(!numberSet.contains(winningLotto.bonusNumber))
    }

    test("보너스 숫자 또는 로또 숫자들에 중복된 숫자가 있으면 예외가 발생한다.") {
        assertThrows[IllegalArgumentException](WinningLotto(List(1, 1, 2, 3, 4, 5), 6))
        assertThrows[IllegalArgumentException](WinningLotto(List(1, 2, 3, 4, 5, 6), 6))
    }

}
