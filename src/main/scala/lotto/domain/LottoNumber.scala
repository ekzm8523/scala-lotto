package lotto.domain

case class LottoNumber (number: Int) {}

object LottoNumber{
    private val MIN_LOTTO_NUMBER = 1
    private val MAX_LOTTO_NUMBER = 45
    private val CACHED_LOTTO_NUMBER: Array[LottoNumber] = (MIN_LOTTO_NUMBER - 1 to MAX_LOTTO_NUMBER)
                                                                .map{num => new LottoNumber(num)}
                                                                .toArray

    def apply(number: Int): LottoNumber = {
        require(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER)
        CACHED_LOTTO_NUMBER(number)
    }

}