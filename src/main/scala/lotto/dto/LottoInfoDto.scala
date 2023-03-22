package lotto.dto

import lotto.domain.{Lotto, WinningLotto}

case class LottoInfoDto(
     userInputPrice: Int,
     userLottos: List[Lotto],
     winningLotto: WinningLotto
)
