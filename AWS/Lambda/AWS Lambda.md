## AWS Lambda란?

AWS Lambda는 서버를 프로비저닝하거나 관리하지 않고도 코드를 실행할 수 있게 해주는 컴퓨팅 서비스이다. AWS Lambda는 필요 시에만 코드를 실행하며, 하루에 몇 개의 요청에서 초당 수천 개의 요청까지 자동으로 확장이 가능합니다. 사용한 컴퓨팅 시간에 대해서만 요금을 지불하면 되고, 코드가 실행되지 않을 때는 요금이 부과되지 않습니다. AWS Lambda에서는 사실상 모든 유형의 애플리케이션이나 백엔드 서비스에 대한 코드를 별도의 관리 없이 실행할 수 있습니다. 

AWS Lambda를 사용하여 **Amazon S3 버킷** 또는 Amazon DynamoDB 테이블의 데이터 변경과 같은 이벤트에 대한 응답으로 코드를 실행할 수 있습니다

___

## Resize an imgae using Amazon S3 and Lambda

https://austinlasseter.medium.com/resize-an-image-using-aws-s3-and-lambda-fda7a6abc61c

`S3 bucket` `IAM-Roles`



___

## Using AWS Lambda with Amazon S3 

https://docs.aws.amazon.com/lambda/latest/dg/with-s3.html

`Recursive invocation` 

If your function writes objects to an S3 bucket, ensure that you are using different S3 buckets for input and output. Writing to the same bucket increases the risk of creating a recursive invocation, which can result in increased Lambda usage and increased costs.

### Warning

If your Lambda function uses the same bucket that triggers it, it could cause the function to run in a loop. For example, if the bucket triggers a function each time an object is uploaded, and the function uploads an object to the bucket, then the function indirectly triggers itself. To avoid this, use two buckets, or configure the trigger to only apply to a prefix used for incoming objects.

하나의 버킷에서 발생한 이벤트에 의해 호출되는 구조에서 발생할 수 있는 문제이다. 예를 들어, 원본 사진이 업로드 됐을 때 썸네일 사진을 생성하고 업로드를 하는 과정에서, 썸네일 사진에 대한 업로드 이벤트에 대해서 다시 썸네일 생성 & 업로드 과정이 재호출되는 문제가 발생할 수 있는 것이다. 

이를 해결하기 위한 방법을 두 가지 제시한다. 

1. 서로 다른 버킷을 활용
2. prefix 조건 활용 (조건)





