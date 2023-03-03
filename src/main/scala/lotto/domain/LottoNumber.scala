package lotto.domain

class CustomException(message: String) extends Exception(message) {}

case class LottoNumber private(number: Int)

object LottoNumber{
    def apply(number: Int): LottoNumber = {
        if(number < 1 || number > 45) {
            throw new CustomException("로또는 1부터 45까지의 숫자로 구성되어야 합니다.")
        }
        new LottoNumber(number)
    }

}
