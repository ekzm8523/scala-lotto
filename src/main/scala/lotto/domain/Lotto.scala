package lotto.domain

import scala.util.Random

class Lotto (val numbers: List[LottoNumber]) {
    if (numbers.length != 6)
        throw new IllegalArgumentException("로또는 6자리 숫자로 구성되어야 합니다.")

    if (numbers.toSet.size != 6)
        throw new IllegalArgumentException("로또에는 중복된 숫자가 존재할 수 없습니다.")
    override def toString: String = numbers.mkString(",")
}

object Lotto {

    private val random = new Random

    def apply(numbers: Iterable[LottoNumber]): Lotto = new Lotto(numbers.toList)

    def apply(numbers: Int*): Lotto = new Lotto(numbers.map(number => LottoNumber(number)).toList)

    def generate(): Lotto = {
        val randomNumbers = random.shuffle(LottoNumber.CACHED_LOTTO_NUMBER.keys)
          .slice(0, 6)
          .toList

        Lotto(randomNumbers:_*)
    }

}

