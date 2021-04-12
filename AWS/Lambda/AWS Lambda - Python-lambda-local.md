# AWS Lambda : Python-lambda-local

## 로컬 테스트 환경 구축하기 (가상환경 활용)



```
$ python3 -m venv ./가상환경 이름 

// 가상환경 활성화 
$ source 지정한 가상환경 이름/bin/activate 

// 가상환경 비활성화 
# deactivate 
```

```
// python-lambda-local 설치 
$ pip3 install python-lambda-local

Within virtualenv, run the following command.
This will install the package with name python-lambda-local in the virtualenv. Now you can use the command python-lambda-local to run your AWS Lambda function written in Python on your own machine.

출처 : https://pypi.org/project/python-lambda-local/d
```



### AWS CLI - Unable to locate credentials

![image-20210412204840025](/Users/youn/Library/Application Support/typora-user-images/image-20210412204840025.png)

```
// AWS Credentials 추가 뒤 위 문제 해결 
https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/install-cliv2-mac.html
```

