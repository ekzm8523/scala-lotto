package lotto.domain

import lotto.LottoGradeEnum
import lotto.dto.LottoInfoDto
import org.scalatest.funsuite.AnyFunSuite

class LottoGameTest extends AnyFunSuite {

    private val WINNING_LOTTO = WinningLotto(List(1, 2, 3, 4, 5, 6), 7)
    private val FIRST_LOTTO = Lotto(1, 2, 3, 4, 5, 6)
    private val SECOND_LOTTO = Lotto(1, 2, 3, 4, 5, 7)
    private val THIRD_LOTTO = Lotto(1, 2, 3, 4, 5, 8)
    private val FOURTH_LOTTO = Lotto(1, 2, 3, 4, 9, 10)
    private val FIFTH_LOTTO = Lotto(1, 2, 3, 8, 9, 10)

    test("로또 결과를 계산할 수 있다.") {
        var USER_INPUT_PRICE = 3000
        var lottoInfoDto = LottoInfoDto(USER_INPUT_PRICE, List(FIRST_LOTTO, SECOND_LOTTO, THIRD_LOTTO), WINNING_LOTTO)
        var res = LottoGame.calculate(lottoInfoDto)
        var expectRateOfReturn = (LottoGradeEnum.FIRST.price + LottoGradeEnum.SECOND.price + LottoGradeEnum.THIRD.price) / USER_INPUT_PRICE
        assert(res.rateOfReturn == expectRateOfReturn)

        USER_INPUT_PRICE = 1000000
        lottoInfoDto = LottoInfoDto(USER_INPUT_PRICE, List(FOURTH_LOTTO, FIFTH_LOTTO), WINNING_LOTTO)
        res = LottoGame.calculate(lottoInfoDto)
        expectRateOfReturn = (LottoGradeEnum.FOURTH.price + LottoGradeEnum.FIFTH.price) / USER_INPUT_PRICE
        assert(res.rateOfReturn == expectRateOfReturn)
    }
}
