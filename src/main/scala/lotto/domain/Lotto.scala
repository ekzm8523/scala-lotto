package lotto.domain

import scala.util.Random

class Lotto (val numbers: List[LottoNumber]) {
    require(numbers.toSet.size == 6, "로또에는 중복된 숫자가 존재할 수 없습니다.")
    require(numbers.size == 6, "로또는 6자리 숫자로 구성되어야 합니다.")

    override def toString: String = numbers.mkString("[" ,", ", "]")
}

object Lotto {

    def apply(numbers: Iterable[Int]): Lotto = new Lotto(numbers.map(LottoNumber(_)).toList)

    def apply(numbers: Int*): Lotto = new Lotto(numbers.map(LottoNumber(_)).toList)

    def generate(): Lotto = Lotto(
        Random.shuffle(LottoNumber.CACHED_LOTTO_NUMBER.keys)
          .slice(0, 6)
          .toList
    )
}
