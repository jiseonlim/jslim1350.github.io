---
category: 'IT tips'
path: 'IT tips/:id'
title: 'git blog에 disqus 적용하기'

layout: nil
---

# disqus
disqus를 사용하면 github blog에 댓글 기능을 넣을 수 있다.

## disqus 가입하기
1. [disqus](https://disqus.com/) 사이트로 이동 & `GET STARTED` 버튼 클릭
![disqus.com](https://user-images.githubusercontent.com/18459083/51119864-4166fa80-1857-11e9-8696-87c8bb8569f6.PNG){: width="800" height="600"}
2. 계정이 없는 경우 `Signup`, 있는 경우 `Login`
![signup](https://user-images.githubusercontent.com/18459083/51119866-4166fa80-1857-11e9-8a29-2b1de85d4251.PNG){: width="800" height="600"}
3. 내 블로그에 적용할거니 `I want to install Disqus on my site` 클릭
![signup](https://user-images.githubusercontent.com/18459083/51119867-4166fa80-1857-11e9-8258-848142a18ebf.PNG){: width="800" height="600"}
4. 정보 입력
![input data before](https://user-images.githubusercontent.com/18459083/51119868-41ff9100-1857-11e9-858a-9dc90ec2532a.PNG){: width="800" height="600"}
![input data after](https://user-images.githubusercontent.com/18459083/51119869-41ff9100-1857-11e9-9fd7-6b74fc2e2b31.PNG){: width="800" height="600"}
5. 무료 버전을 사용하려면 `Basic` 클릭
![version](https://user-images.githubusercontent.com/18459083/51119870-42982780-1857-11e9-927f-a0470fc23cbf.PNG){: width="800" height="600"}
![basic](https://user-images.githubusercontent.com/18459083/51119871-42982780-1857-11e9-89d4-942e292bfb25.PNG){: width="800" height="600"}
6. 본인의 사이트에 맞게 `platform` 선택 (이 블로그의 경우 `Jekyll`)
![PLATFORM](https://user-images.githubusercontent.com/18459083/51119872-42982780-1857-11e9-94bd-685276f002bc.PNG){: width="800" height="600"}
![Jekyll](https://user-images.githubusercontent.com/18459083/51119873-42982780-1857-11e9-82a4-99266ad2217b.PNG){: width="800" height="600"}
8. 제공된 코드를 알맞게 삽입
![code1](https://user-images.githubusercontent.com/18459083/51119874-4330be00-1857-11e9-9075-81dac0aeffc9.PNG){: width="800" height="600"}
![code2](https://user-images.githubusercontent.com/18459083/51119877-4330be00-1857-11e9-94a6-64b1d4533bfb.PNG){: width="800" height="600"}

## disqus code 삽입하기
이 블로그의 경우에는 index.html, assets.css 파일을 수정했다.
index.html만 수정하는 경우 disqus가 navigation영역까지 침범하기 때문에 assets.css에서 flex 설정을 주었다.

```
body {
    margin: 0;
    display: flex;
}
#content {
  padding: 20px;
  padding-left: 260px;
  max-width: 700px;
  flex: 1;
}
```

## 완성!
![compelete](https://user-images.githubusercontent.com/18459083/51119878-4330be00-1857-11e9-8644-ad4c6c637928.PNG){: width="800" height="600"}
