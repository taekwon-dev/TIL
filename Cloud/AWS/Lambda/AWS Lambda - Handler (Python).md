# AWS Lambda - Handler (Python)

출처 : https://docs.aws.amazon.com/ko_kr/lambda/latest/dg/python-handler.html



AWS Lambda 함수 핸들러는 이벤트를 처리하는 함수 코드의 메소드. 함수가 호출되면 Lambda에서 핸들러 메소드를 실행한다. 

(핸들러가 존재하거나 응답을 반환할 때, 또 다른 이벤트를 처리하기 위해 사용할 수 있다.)

```python
def handler_name(event, context) :
	... 
	return some_value
```



### 1. 핸들러 이름 지정 

기본적으로 함수 핸들러 이름은 임의로 지정할 수 있지만, Lambda 콘솔의 기본 값은 `lambda_function.lambda_handler` 입니다. 이 이름 생성 규칙은 다음과 같습니다.

`lambda_function` **from**  `lambda_function.py`

`lambda_handler` **from**  `handler_name(name of method)`

"Lambda 콘솔에서 함수 핸들러에 대해 다른 이름을 선택하는 경우 **런타임 설정(Runtime settings)** 창에서 이름을 업데이트해야 합니다. 다음 예제에서는 Lambda 콘솔의 Lambda 함수 핸들러를 보여줍니다."

### 2. 작동 방식

Lambda에서 함수 핸들러가 호출될 때 Lambda 런타임은 함수 핸들러에 두 개의 인수를 전달한다. (event, context)

**1) event :**

이벤트 객체는 Lambda 함수가 처리할 데이터가 포함된 JSON 형식의 문서이다. Lambda 런타임은 이벤트를 객체로 변환한 후 함수 코드에 전달한다. 이 객체는 일반적으로 Python `dict` 유형이다. (또한 `list`, `str`, `int`, `float`, 또는 `NoneType`)

이벤트 객체에는 호출 서비스의 정보가 포함되어 있다. 함수를 호출할 때 이벤트의 구조와 내용을 결정한다. 

___

<u>Event</u>

An event is a JSON-formatted document that contains data for a Lambda function to process. The runtime converts the event to an object and passes it to your function code. When you invoke a function, you determine the structure and contents of the event.

https://docs.aws.amazon.com/lambda/latest/dg/gettingstarted-concepts.html#gettingstarted-concepts-event

____

```json
// 예시   
"Records": [
    {
      "eventVersion": "2.0",
      "eventSource": "aws:s3",
      "awsRegion": "ap-northeast-2",
      "eventTime": "1970-01-01T00:00:00.000Z",
      "eventName": "ObjectCreated:Put", // 이벤트 이름 
      "userIdentity": {
        "principalId": "EXAMPLE"
      },
      "requestParameters": {
        "sourceIPAddress": "127.0.0.1"
      },
      "responseElements": {
        "x-amz-request-id": "EXAMPLE123456789",
        "x-amz-id-2": "EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH"
      },
      "s3": {
        "s3SchemaVersion": "1.0",
        "configurationId": "testConfigRule",
        "bucket": {
          "name": "example",
          "ownerIdentity": {
            "principalId": "EXAMPLE"
          },
          "arn": "arn:aws:s3:::example"
        },
        "object": {
          "key": "directory/name",
          "size": 1024,
          "eTag": "0123456789abcdef0123456789abcdef",
          "sequencer": "0A1B2C3D4E5F678901"
        }
      }
    }
  ]
}
```

**2) context** :

컨텍스트 객체는 런타임에 Lambda에 의해 함수로 전달된다. 이 객체는 호출, 함수 및 런타임 환경에 관한 정보를 제공하는 메소드 및 속성을 제공한다. 



