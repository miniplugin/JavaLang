#### 구름IDE에서 깃허브 연동방법
- git init
- git add .
- git commit -m "first commit"
- git branch -M master
- git remote add origin https://github.com/miniplugin/clang.git
- git push -u origin master
#### Error: refname refs/heads/master not found 에러처리방법
- git fetch
- git reset --hard origin/master
- 결과는 root@goorm:/workspace/iot_c/src(master)# 이렇게 마스터로 나오면 됩니다.