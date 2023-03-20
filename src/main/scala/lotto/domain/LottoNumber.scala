package lotto.domain


object LottoNumber {
    private val MIN_LOTTO_NUMBER = 1
    private val MAX_LOTTO_NUMBER = 45
    val CACHED_LOTTO_NUMBER: Map[Int, LottoNumber] = {
        (LottoNumber.MIN_LOTTO_NUMBER to MAX_LOTTO_NUMBER)
          .map { num => num -> new LottoNumber(num) }
          .toMap
    }

    def apply(number: Int): LottoNumber = {
        require(
            isValidRangeNumber(number),
            s"숫자는 $LottoNumber.MIN_LOTTO_NUMBER 부터 $LottoNumber.MAX_LOTTO_NUMBER 사이의 값을 가져야 합니다."
        )
        CACHED_LOTTO_NUMBER(number)
    }

    private def isValidRangeNumber(number: Int): Boolean =
        LottoNumber.MIN_LOTTO_NUMBER <= number && number <= LottoNumber.MAX_LOTTO_NUMBER

}

class LottoNumber private (val number: Int) {
    override def toString: String = number.toString
}

