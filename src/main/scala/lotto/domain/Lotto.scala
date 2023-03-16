package lotto.domain

import scala.util.Random

class Lotto (val numbers: List[LottoNumber]) {
    if (numbers.length != 6)
        throw new IllegalArgumentException("로또는 6자리 숫자로 구성되어야 합니다")

    override def toString: String = numbers.mkString(",")
}

object Lotto {

    private val random = new Random
    def apply(numbers: Iterable[Int]): Lotto = new Lotto(numbers.map(number => LottoNumber(number)).toList)

    def apply(numbers: Int*): Lotto = new Lotto(numbers.map(number => LottoNumber(number)).toList)

    def generate(): Lotto = {
        val randomNumbers = for (_ <- 1 to 6) yield (random nextInt 45) + 1
        Lotto(randomNumbers)
    }

}

