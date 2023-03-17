package lotto

import lotto.domain.{Lotto, WinningLotto}
import lotto.dto.LottoGameResultDto

import scala.io.StdIn.{readInt, readLine}
import scala.util.{Success, Try}


object LottoView {

    private val REQUEST_RECEIVE_PURCHASE_INPUT = "구매금액을 입력해 주세요."
    private val REQUEST_RECEIVE_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요. (ex : 1, 2, 3, 4, 5, 6)"
    private val REQUEST_RECEIVE_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    def receivePurchasePrice(): Int = {
        println(REQUEST_RECEIVE_PURCHASE_INPUT)
        readIntWithErrorMessage()
    }

    private def readIntWithErrorMessage(): Int = {
        Try(readInt()) match {
            case Success(value) => value
            case _ => throw new RuntimeException("숫자만 입력했는지 잘 확인해주세요.")
        }
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
        Try(readLine().split(", ").map(_.toInt)) match {
            case Success(value) if value.length == 6 => value
            case Success(_) => throw new RuntimeException("6자리 숫자를 입력해주세요.")
            case _ => throw new RuntimeException("입력 포멧을 잘 확인해주세요.")
        }
    }

    private def receiveBonusNumber(): Int = {
        println(REQUEST_RECEIVE_BONUS_NUMBER)
        readIntWithErrorMessage()
    }

    def printResult(gameResult: LottoGameResultDto): Unit = {
        println("당첨 통계")
        println("------------")
        for(lottoGradeCount <- gameResult.lottoGradeCounts)
            println(s"${lottoGradeCount.lottoGrade.needMatchCount}개 일치 (${lottoGradeCount.lottoGrade.price}원)- ${lottoGradeCount.count}개")
        println(s"총 수익률은 ${gameResult.rateOfReturn}입니다.")
    }
}
