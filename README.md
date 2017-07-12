## Install

Basic Java starter project for serverless projects using Serverless Application Model, Amazon API Gateway, and AWS Lambda.

Run
```
mvn package 
aws cloudformation package \
    --template-file template.yaml \
    --s3-bucket [YOUR_S3_BUCKET] \
    --output-template-file packaged-template.yaml

aws cloudformation deploy \
    --template-file packaged-template.yaml \
    --stack-name [YOUR_STACK_NAME] \
    --capabilities CAPABILITY_IAM
```
## Run
```
curl https://[YOUR_API_ID].execute-api.us-west-2.amazonaws.com/Prod/hello
```