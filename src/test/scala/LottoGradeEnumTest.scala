import lotto.LottoGradeEnum
import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

class LottoGradeEnumTest extends AnyFunSuite{
    test("getGrade Match Test") {
        assert(LottoGradeEnum.getGrade(6, true).eq(LottoGradeEnum.FIRST))
        assert(LottoGradeEnum.getGrade(6, false).eq(LottoGradeEnum.FIRST))
        assert(LottoGradeEnum.getGrade(5, true).eq(LottoGradeEnum.SECOND))
        assert(LottoGradeEnum.getGrade(5, false).eq(LottoGradeEnum.THIRD))
        assert(LottoGradeEnum.getGrade(4, true).eq(LottoGradeEnum.FOURTH))
        assert(LottoGradeEnum.getGrade(4, false).eq(LottoGradeEnum.FOURTH))
        assert(LottoGradeEnum.getGrade(3, true).eq(LottoGradeEnum.FIFTH))
        assert(LottoGradeEnum.getGrade(3, false).eq(LottoGradeEnum.FIFTH))
        assert(LottoGradeEnum.getGrade(2, true).eq(LottoGradeEnum.NONE_GRADE))
        assert(LottoGradeEnum.getGrade(2, false).eq(LottoGradeEnum.NONE_GRADE))
        assert(LottoGradeEnum.getGrade(1, true).eq(LottoGradeEnum.NONE_GRADE))
        assert(LottoGradeEnum.getGrade(1, false).eq(LottoGradeEnum.NONE_GRADE))
        assert(LottoGradeEnum.getGrade(0, true).eq(LottoGradeEnum.NONE_GRADE))
        assert(LottoGradeEnum.getGrade(0, false).eq(LottoGradeEnum.NONE_GRADE))
        assertThrows[IllegalArgumentException](LottoGradeEnum.getGrade(7, true).eq(LottoGradeEnum.NONE_GRADE))
        assertThrows[IllegalArgumentException](LottoGradeEnum.getGrade(-1, true).eq(LottoGradeEnum.NONE_GRADE))
    }
}
