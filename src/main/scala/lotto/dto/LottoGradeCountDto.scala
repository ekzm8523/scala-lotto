package lotto.dto

import lotto.LottoGradeEnum.LottoGradeEnum
case class LottoGradeCountDto(
    lottoGrade: LottoGradeEnum,
    count: Int
)
