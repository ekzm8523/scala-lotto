package lotto

import lotto.domain.{Lotto, WinningLotto}
import scala.io.StdIn.{readInt, readLine}


object LottoView {
    private val REQUEST_RECEIVE_PURCHASE_INPUT = "구매금액을 입력해 주세요."
    private val REQUEST_RECEIVE_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요."
    private val REQUEST_RECEIVE_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    def receivePurchasePrice(): Int = {
        println(REQUEST_RECEIVE_PURCHASE_INPUT)
        readInt()
    }

    def printPurchaseLottos(lottos: List[Lotto]): Unit = {
        println(s"${lottos.length}개를 구매했습니다.")
        lottos foreach println
    }

    def receiveWinningLotto(): WinningLotto = {
        WinningLotto(receiveWinningLottoNumbers(), receiveBonusNumber())
    }

    private def receiveWinningLottoNumbers(): Array[Int] = {
        println(REQUEST_RECEIVE_WINNING_LOTTO_NUMBERS)
        readLine().split(",").map(_.toInt) // Todo: exception 처리 고려
    }

    private def receiveBonusNumber(): Int = {
        println(REQUEST_RECEIVE_BONUS_NUMBER)
        val bonusNumber: Int = readInt()
        bonusNumber
    }

}
