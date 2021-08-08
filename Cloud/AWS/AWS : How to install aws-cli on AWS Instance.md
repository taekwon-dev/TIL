# AWS : How to install aws-cli on Ubuntu 18.04

https://ubunlog.com/en/aws-cli-installation-ubuntu1804lts/

### With Python PIP :

AWS CLI is a pyhton module. The advantage of installing AWS CLI as a Python module is that always **Get an updated version of the AWS CLI**. It is easy to update AWS CLI if it's installed as a Python module. We also won't need root privileges to install the AWS CLI in this way. If we need it, AWS CLI too can be installed in a virtual Python environment.

```bash
$ source ./aws-lambda-local/bin/activate 
(aws-lambda-local) 가상환경 

$ pip -V 
pip 20.0.2 from /root/aws-lambda-local/lib/python3.8/site-packages/pip (python 3.8)

$ pip3 install awscli 

$ python3 -m awscli --version 
aws-cli/1.19.64 Python/3.8.5 Linux/5.4.0-1037-aws botocore/1.20.64
```



