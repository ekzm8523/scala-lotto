# scala-lotto

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

```agsl
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 줄여쓰지 않는다(축약 금지).


## 설계
- Domain
- [ ] Lotto
  - 6개의 LottoNumber로 구성
  - 중첩 불가능
  - 생성 방법
    - 수동 생성
    - 자동 생성
  - [ ] LottoNumber 
    - 1~45 사이의 숫자만 가질 수 있음
    - static factory method
- [ ] WinningLotto (Lotto + BonusNumber)
  - [ ] BonusNumber (LottoNumber)
    - WinningLotto 안에만 존재
    - WinningLotto의 Lotto에 존재하지 않는 숫자여야함
- [ ] Ticket
  - 티켓을 통해 로또를 구매


- DTO
  - [ ] UserLottoRequest
  - [ ] UserLottoResponse


- View
  - 입력을 받아 UserLottoRequest를 생성한다
  - LottoGame이 결과로 만들어 준 UserLottoResponse를 출력한다.


- Controller
  - [ ] LottoGame
