package lotto.domain

import scala.util.Random

class WinningLotto (val lotto: Lotto, val bonusNumber: LottoNumber) {
    require(!lotto.numbers.contains(bonusNumber), "보너스 숫자는 로또의 숫자와 겹칠 수 없습니다.")

    def this(lotto: List[Int], bonusNumber: Int) = this(Lotto(lotto), LottoNumber(bonusNumber))
    override def toString: String = s"LottoNumber : $lotto \t bonusNumber : $bonusNumber"

}

object WinningLotto {

    def apply(lotto: Iterable[Int], bonusNumber: Int): WinningLotto = {
        new WinningLotto(lotto.toList, bonusNumber)
    }
    def generate(): WinningLotto = {
        val bonusNumber::numbers = Random.shuffle(LottoNumber.CACHED_LOTTO_NUMBER.keys)
          .slice(0, 7)
          .toList

        new WinningLotto(lotto=numbers, bonusNumber)
    }
}

