package lotto

import lotto.domain.{Lotto, LottoGame, WinningLotto}
import lotto.dto.{LottoGameResultDto, LottoInfoDto}

object LottoController {

    private val LOTTO_PRICE: Int = 1000

    def gameStart(): Unit = {
        val price: Int = LottoView.receivePurchasePrice()
        val issueCount: Int = price / LOTTO_PRICE
        val lottos: List[Lotto] = Lotto.issueLottos(issueCount)
        LottoView.printPurchaseLottos(lottos)

        val winningLotto: WinningLotto = LottoView.receiveWinningLotto()
        val lottoInfoDto: LottoInfoDto = LottoInfoDto(price, lottos, winningLotto)
        val gameResult: LottoGameResultDto = LottoGame.calculate(lottoInfoDto)
        LottoView.printResult(gameResult)

    }

}
