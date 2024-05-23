# 액티비티 이동 순서 중요 기말고사
(전)onCreate ->(전)onStart->(전)onResume -(액티비티실행)-(이동)->(전)onPause -> (후)onCreate -> (후)onStart -> (후)onResume -> (전)onStop -(전 액티비티로 이동)-> (후)onPause -> (전)onRestart -> (전)onStart -> (전)onResume -> (후)onStop -> (후)onDestroy

Restart 후의 Start와 처음시작Start 구분 해야됨
create, start, resume 후에 전꺼 stop
