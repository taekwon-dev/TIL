# AWS : IAM Identities (users, user groups, and roles)

https://docs.aws.amazon.com/IAM/latest/UserGuide/introduction.html

https://docs.aws.amazon.com/IAM/latest/UserGuide/id.html

이 글에서는 IAM에 대한 개념과 각 구성 요소를 이해하기 위해 정리된 글입니다. 

___

### What is IAM :

AWS Identity and Access Management (IAM) is a web service that helps you securely access to AWS resources. You use IAM to control who is authenticated and authorized to user resources.

IAM 서비스는 AWS 리소스에 안전하게 접근할 수 있도록 돕는 서비스이고, 인증/인가 제어를 위해 사용하는 서비스이다.

___

**Having trouble signing in to AWS?** Make sure that you're on the correct [AWS sign-in page](https://docs.aws.amazon.com/IAM/latest/UserGuide/console.html) for your type of user. If you are the AWS account root user (account owner), you can sign in to AWS using the credentials that you set up when you created the AWS account. If you are an IAM user, your account administrator can give you the credentials that you can use to sign in to AWS

`Account Owner` 

`IAM User` : 

<u>Your account administrator</u>가 credentials 정보를 활용할 수 있는 권한을 부여하고, 이를 통해 AWS에 로그인 할 수 있다.

____

### AWS account root user :

When you first create an Amazon Web Services (AWS) account, you begin with a single sign-in identity that has complete access to all AWS services and resources in the account. This identity is called **the AWS account *root user*** and is accessed by signing in with the email address and password that you used to create the account.

회원가입 후 직접 등록한 메일과 패스워드를 통해서 로그인(인증)하는 경우, 이 경우 인증을 얻은 유저를 **AWS account root user**라고 한다. (모든 권한)

### ! Important

AWS에서는 일상 업무 중 루트 유저 권한으로 접근하는 것을 지양할 것을 강력히 권고한다. (https://docs.aws.amazon.com/IAM/latest/UserGuide/best-practices.html#create-iam-users) 

___

### IAM users :

An IAM user is **an entity** that you create in AWS. The IAM user represents **the person or service** who uses the IAM user to interact with AWS. A primary use for IAM users is to give people **the ability to sign in to the AWS Management Console** for interactive tasks and to make programmatic requests to AWS services **using the API or CLI**.

___

### IAM user groups :

An IAM user group is a collection of IAM users. 

___

### IAM roels :

An IAM role is very similar to a user, in that it is an identity with permission policies that determine what the identity can and cannot do in AWS.  However, a role does not have any credentials (password or access keys) associated with it. Instead of being uniquely associated with one person, a role is intended to be assumable by anyone who needs it.

