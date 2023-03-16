package lotto.domain


object LottoNumber{
    private val MIN_LOTTO_NUMBER = 1
    private val MAX_LOTTO_NUMBER = 45
    val CACHED_LOTTO_NUMBER: Map[Int, LottoNumber] = (LottoNumber.MIN_LOTTO_NUMBER to MAX_LOTTO_NUMBER)
      .map { num => num -> new LottoNumber(num) }
      .toMap

    def apply(number: Int): LottoNumber = {
        require(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER)
        CACHED_LOTTO_NUMBER(number)
    }

}

class LottoNumber (val number: Int) {

    if (number < LottoNumber.MIN_LOTTO_NUMBER || LottoNumber.MAX_LOTTO_NUMBER < number)
        throw new IllegalArgumentException(s"숫자는 $LottoNumber.MIN_LOTTO_NUMBER 부터 $LottoNumber.MAX_LOTTO_NUMBER 사이의 값을 가져야 합니다.")
    override def toString: String = number.toString
}

