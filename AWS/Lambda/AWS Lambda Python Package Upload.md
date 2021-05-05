

# AWS Lambda Python - Package Upload 

http://dveamer.github.io/backend/ResizingImagesOnAwsLambda

http://dveamer.github.io/backend/AwsLambdaUsingPythonZip

**상황** : 

AWS Lambda 핸들러에서 S3에 저장되어 있는 원본의 EXIF 데이터를 통해 이미지 로테이트 문제를 처리했어야 했다.  해당 과정에서 `piexif` 패키지가 필요했고, 이를 활용하기 위해 AWS Lambda에 업로드해야 하는 상황이다. 

___

AWS Lambda 함수의 코드는 스크립트 또는 컴파일된 프로그램과 해당 종속 항목으로 구성된다. 배포 패키지를 사용하여 Lambda 함수 코드를 배포한다. 이 때 AWS Lambda는 두 가지 유형의 배포 패키지 (컨테이너 이미지 또는 **.zip 파일**)을 지원한다.

https://docs.aws.amazon.com/ko_kr/lambda/latest/dg/python-package.html

____

**.zip**

```bash
// zip 명령어를 통해서 업로드할 패키지 디렉토리를 .zip 압축한다.
$ zip -r piexif.zip piexif 
```

