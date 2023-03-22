package lotto.domain

import lotto.LottoGradeEnum
import lotto.LottoGradeEnum.LottoGradeEnum
import lotto.dto.{LottoGameResultDto, LottoGradeCountDto, LottoInfoDto}

import scala.collection.mutable
object LottoGame {

    def calculate(lottoInfoDto: LottoInfoDto): LottoGameResultDto = {
        val lottoGradeCounts: List[LottoGradeCountDto] = getLottoGradeCounter(lottoInfoDto)
        val rateOfReturn: Float = getTotalLottoPrize(lottoGradeCounts) / lottoInfoDto.userInputPrice
        LottoGameResultDto(lottoGradeCounts, rateOfReturn)
    }

    private def getLottoGradeCounter(lottoInfoDto: LottoInfoDto): List[LottoGradeCountDto] = {
        val lottoGradeCounterWithDefaultValueZero: mutable.Map[LottoGradeEnum, Int] =
            mutable.Map(LottoGradeEnum.values.toList.map(_ -> 0): _*)

        lottoInfoDto.userLottos
          .map(getLottoGrade(_, lottoInfoDto.winningLotto))
          .foreach(lottoGrade => lottoGradeCounterWithDefaultValueZero(lottoGrade) += 1)

        lottoGradeCounterWithDefaultValueZero
          .toList
          .map(res => LottoGradeCountDto(res._1, res._2))
          .sortBy(_.lottoGrade.price)
    }

    private def getLottoGrade(lotto: Lotto, winningLotto: WinningLotto): LottoGradeEnum =
        LottoGradeEnum getGrade(
          getMatchCount(lotto, winningLotto),
          lotto.numbers contains winningLotto.bonusNumber
        )

    private def getMatchCount(lotto: Lotto, winningLotto: WinningLotto): Int =
        (lotto.numbers.toSet & winningLotto.lotto.numbers.toSet).size

    private def getTotalLottoPrize(lottoGradeCounts: List[LottoGradeCountDto]): Int =
        lottoGradeCounts.foldLeft(0)((sum, elem) => sum + elem.count * elem.lottoGrade.price)

}
