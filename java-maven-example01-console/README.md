# Java-Maven Example01 console
Semplice lambda in lingiaggio Java creata con Maven e rilasciata da console web o con SAM. Vedere i prerequisiti nel README generale


Riferimento: [documentazione ufficiale AWS Lambda Java](https://docs.aws.amazon.com/lambda/latest/dg/java-package.html)


## Come creare il progetto
See [Bootstrapping a java lambda](https://aws.amazon.com/it/blogs/developer/bootstrapping-a-java-lambda-application-with-minimal-aws-java-sdk-startup-time-using-maven/)
Comando maven per la creazione:

```
mvn archetype:generate -DarchetypeGroupId=software.amazon.awssdk -DarchetypeArtifactId=archetype-lambda -DarchetypeVersion=2.15.79
```

Al termine nel progetto si possono commentare un po' di oggetti tra cui i riferimenti alla classe DependencyFactory che non serve. Nella classe App.java aggiunto un log.


## Building
Per compilare il progetto si usa il comando standard maven:
```
mvn clean install
```

### Testing locally
Per testare localemente si può usare 
```
sam local invoke
```
In caso di errore "Running AWS SAM projects locally requires Docker. Have you got it installed and running?" bisogna installare docker nel sistema.


## Deploy da console
Per caricare in un bucket il jar crato usare il comando
```
aws s3 cp ./target/java-maven-example01-console-1.0-SNAPSHOT.jar s3://alberto-input
```
Da console eseuire gli step di creazione indicando il nome, il tipo Java 1.8. Creata la lambda caricare il codice da S3 (o da zip locale).


Bisogna modificare il Hander della lambda indicando il package e il nome della classe, in questo esempio deve essere:
```
it.alnao.App::handleRequest
```
Nota: su permissioni è già abilitato a CloudWatch di default così i log finiranno su CloudWatch, eseguendo test da console si vede il risultato afferamativo e si può vedere il log su CloudWatch. La rimozione della lambda è da fare a mano da console.


## Deploy con SAM-CloudFormation
Il comando per eseguire il deploy con SAM è:
```
sam deploy --guided
```
Indicando il nome dello stack (esempio java-maven-example01-sam), la region e se salare il samconfig.tolm. 
Alla conferma saranno visualizzate le risorse gestite da SAM-CloudFormation
```
Operation  LogicalResourceId    ResourceType            Replacement                                  
+ Add      AppFunctionRole      AWS::IAM::Role          N/A                                          
+ Add      AppFunction          AWS::Lambda::Function   N/A                                          
...
Successfully created/updated stack - java-maven-example01-sam in eu-west-1
```
See [Deploying Serverless Applications](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-deploying.html) for more info.


### Per rimuovere con SAM-CloudFormation
Per rimuovere lo stack creato con SAM-CloudFormation:
```
sam delete
```


## Deploy con CLI
Anche se non da usare, sono elencati i comandi AWS-CLI pura senza uso di SAM. 
See [documentazione AWS-CLI](https://docs.aws.amazon.com/lambda/latest/dg/gettingstarted-awscli.html)
and [documentazione AWS Lambda](https://docs.aws.amazon.com/cli/latest/reference/lambda/create-function.html)


Comando per creare la regola IAM dal file cli_role (regola necessaria per l'esecuzione della lambda)
```
aws iam create-role --role-name lambda-role --assume-role-policy-document file://cli_role.json
```

Comando per creare la Lambda Function
```
aws lambda create-function --function-name java-maven-example01-cli --zip-file fileb://target/java-maven-example01-console-1.0-SNAPSHOT.jar --runtime java8 --role arn:aws:iam::740456629644:role/lambda-role --handler it.alnao.App::handleRequest
```

Comando per invocare la Lambda e salvare output
```
aws lambda invoke --function-name java-maven-example01-cli outputfile.txt
```

Comandi vari per aggiornare, recupeare il dettaglio e rimuovere la lambda.
```
aws lambda update-function-code --function-name java-maven-example01-cli --zip-file fileb://target/java-maven-example01-console-1.0-SNAPSHOT.jar 
aws lambda list-functions --max-items 10
aws lambda get-function --function-name java-maven-example01-cli
aws lambda delete-function --function-name java-maven-example01-cli
aws iam delete-role --role-name lambda-role
```

# Original Readme created by Maven


This project contains an AWS Lambda maven application with [AWS Java SDK 2.x](https://github.com/aws/aws-sdk-java-v2) dependencies.
## Prerequisites
- Java 1.8+
- Apache Maven
- [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)
- Docker

## Development

The generated function handler class just returns the input. The configured AWS Java SDK client is created in `DependencyFactory` class and you can 
add the code to interact with the SDK client based on your use case.

#### Building the project
```
mvn clean install
```

#### Testing it locally
```
sam local invoke
```

#### Adding more SDK clients
To add more service clients, you need to add the specific services modules in `pom.xml` and create the clients in `DependencyFactory` following the same 
pattern as ${serviceClientVariable}Client.

## Deployment

The generated project contains a default [SAM template](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/sam-resource-function.html) file `template.yaml` where you can 
configure different properties of your lambda function such as memory size and timeout. You might also need to add specific policies to the lambda function
so that it can access other AWS resources.

To deploy the application, you can run the following command:

```
sam deploy --guided
```

See [Deploying Serverless Applications](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-deploying.html) for more info.




# AlNao.it
Nessun contenuto in questo repository è stato creato con IA o automaticamente, sono stati tutti scritti con molta pazienza da Alberto Nao. 
Se il codice è stato preso, anche parzialmente, da altri siti/progetti è sempre indicata la fonte.
Per maggior informazioni visitare il sito [alnao.it](https://www.alnao.it/).

## License
**Free Software, Hell Yeah!**
See [MIT](https://it.wikipedia.org/wiki/Licenza_MIT)


Copyright (c) 2023 AlNao.it

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.