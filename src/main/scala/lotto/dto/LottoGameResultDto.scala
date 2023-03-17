package lotto.dto

case class LottoGameResultDto(
    lottoGradeCounts: List[LottoGradeCountDto],
    rateOfReturn: Float
 )
