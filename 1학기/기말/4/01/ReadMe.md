# 액티비티 이동 순서 중요 기말고사
(전)onCreate ->(전)onStart->(전)onResume -(액티비티실행)-(이동)->(전)onPause -> (후)onCreate -> (후)onStart -> (후)onResume -> (전)onStop -(전 액티비티로 이동)-> (후)onPause -> (전)onRestart -> (전)onStart -> (전)onResume -> (후)onStop -> (후)onDestroy

Restart 후의 Start와 처음시작Start 구분 해야됨

새 액티비티 만드는 방법
![새 액티비티 만들기](https://github.com/moolgutree/mobileproject/blob/main/1%ED%95%99%EA%B8%B0/%EA%B8%B0%EB%A7%90/4/01/%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7(1).png)

create, start, resume 후에 전꺼 stop

![Activity 이동순서](https://github.com/moolgutree/mobileproject/blob/main/1%ED%95%99%EA%B8%B0/%EA%B8%B0%EB%A7%90/4/01/%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC/%EC%88%9C%EC%84%9C.PNG)

> 이동 전 파일정보 저장은 onStart나 onResume에서 파일정보 저장해야됨(정보가 있냐 없냐 구분해야됨)
> 
> 이동 버튼 클릭하더라도 다음 넘어가기 전에 처리할 내용은 처리하고 이동됨

# activity 이동
![Activity 이동](https://github.com/moolgutree/mobileproject/blob/main/1%ED%95%99%EA%B8%B0/%EA%B8%B0%EB%A7%90/4/01/%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC/activity%20%EC%9D%B4%EB%8F%99.PNG)

# 데이터 들고가기 -> 갖고오기는 조금 더 복잡함
intent로 데이터 넘겨주는 작업
데이터 꺼내오는 작업

# 코틀린 생성
![이렇게생성하면 Layout없음](https://github.com/moolgutree/mobileproject/blob/main/1%ED%95%99%EA%B8%B0/%EA%B8%B0%EB%A7%90/4/01/%EC%82%AC%EC%A7%84%ED%8C%8C%EC%9D%BC/Layout%EC%97%86%EC%9D%8C.png)
이렇게생성하면 Layout없음
