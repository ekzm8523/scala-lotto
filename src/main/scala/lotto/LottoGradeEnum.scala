package lotto

object LottoGradeEnum extends Enumeration {
    type LottoGradeEnum = Value
    private case class LottoGradeInfoValue(name: String, needMatchCount: Int, needBonusMatch: Boolean, price: Int) extends Val(nextId, name) {
        override def toString(): String = s"$name : \n" +
          s"\t 필요한 매치 카운트 : $needMatchCount \n" +
          s"\t 보너스 매치 여부 : $needBonusMatch \n" +
          s"\t 상금 : $price\n"

    }

    val FIRST: LottoGradeEnum = LottoGradeInfoValue("first", 6, false, 2000000000)
    val SECOND: LottoGradeEnum = LottoGradeInfoValue("second", 5, true, 300000000)
    val THIRD: LottoGradeEnum = LottoGradeInfoValue("third", 5, false, 1500000)
    val FOURTH: LottoGradeEnum = LottoGradeInfoValue("fourth", 4, false, 50000)
    val FIFTH: LottoGradeEnum = LottoGradeInfoValue("fifth", 3, false, 5000)
    val NONE_GRADE: LottoGradeEnum = LottoGradeInfoValue("none_grade", 0, false, 0)

    def getGrade(matchCount: Int, bonusMatch: Boolean): LottoGradeEnum = {
        require(0 <= matchCount && matchCount <= 6, "matchCount는 0이상 6이하의 값이어야 합니다.")
        (matchCount, bonusMatch) match {
            case (6, _) => FIRST
            case (5, true) => SECOND
            case (5, _) => THIRD
            case (4, _) => FOURTH
            case (3, _) => FIFTH
            case _ => NONE_GRADE
        }
    }

}