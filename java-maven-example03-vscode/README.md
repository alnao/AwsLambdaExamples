# AwsLambdaExamples Java

## Example3 Visual Studio Code
Progetto creato in Visual studio Code con AWS Toolkit

Dopo aver installato AWS Toolkit basta aprire il riquadro dei comandi (Ctrl+Maiusc+P) e selezionare la voce
```
> Create lambda SAM application
```
In questa piccola procedura guidata è possibile selezionare il tipo di linguaggio (java e maven), il modello (consigliato il base HelloWorld) e la cartella dove salvare il progetto.
Il risultato sarà un piccolo progetto con i componenti
- cartella event con un file json di esempio che permetterà di eseguire i test da locale
- il file template.yaml con il template completo di cloudformation con la definizione della lambda e la definizione della API tramite gateway
- il progetto java-maven in una sottocartella con la classe App già pronta per essere eseguita
In questo piccolo progetto di esempio la lambda esegue una chiamata al servizio "checkip" per ritornare l'ip del chiamante.
E' possibile eseguire localmente la lambda usando il comando sam invocando la lambda e usando il file json di esempio come evento
```
$ sam local invoke HelloWorldFunction --event events/event.json
```
In questo caso il comando eseguirà sul docker locale la lambda e ritornerà il risultato. E' ovvio che docker deve essere installato e l'utente deve disporre delle autorizzazioni per eseguire i comandi docker.  
In questo caso non funziona la funzionalità "upload lambda" disponibile cliccando con il tasto destro sul nome della cartella appena creata ma bisogna usare la CLI-SAM.
Il primo metodo per eseguire il rilascio è usare la riga di comando per compilare il progetto
```
$ sam build 
```
che crea una sottocatella .aws-sam con dentro il compilato da maven pronto per essere rilasciato con il comando
```
$ sam deploy --guided 
```

con il quale è possibile indicare ad AWS alcuni parametri come il nome del template su CloudFormation e poi viene salvato un file samconfig.toml con le configurazioni salvate. Una volta creato si può andare nella console web per vedere la lambda e il suo template CloudFormation, inoltre è possibile usare il toolkit per eseguire la lambda. 


Per rimuovere la lambda basta lanciare uno dei comandi: 
```
aws cloudformation delete-stack --stack-name es03j
sam delete --stack-name es03j
```


Il secondo metodo per eseguire il rilascio è usare il toolkit: dal riquadro dei comandi bisogna selezionare la voce
```
> AWS deploy sam application
```
dove bisogna indicare il file yaml base, la region, il nome del bucket di appoggio e il nome del template. Nella output sarà possibile vedere lo stato avanzamento e l'esito finale del caricamento.
Usando l'esensione del AWS Toolkit è possibile vedere l'elenco di tutte le funzionli Lambda create ed è possibile selezionare la voce "Invoke lambda" cliccando con il tasto destro del mouse in una lambda, nella schermata è possibile anche impostare i parametri di chiamata con la possiblità di selezionare il file json di esempio.


Per distruggere e rimuovere la lambda è possibile selezionare il template CloudFormation creato in fase di caricamento e selezionare l'opzione "Delete CloudFormation Stack", ovviamente tale operazione andrà a rimuovere tutte le risorse del template comprese altre se inserite manualmente quindi bisogna sempre prestare attenzione a quando si cancella uno stack in CloudFormation.


La guida completa è disponibile nel sito ufficiale (https://docs.aws.amazon.com/toolkit-for-vscode/latest/userguide/welcome.html)


# java-maven-example03-vscode

This project contains source code and supporting files for a serverless application that you can deploy with the SAM CLI. It includes the following files and folders.

- HelloWorldFunction/src/main - Code for the application's Lambda function.
- events - Invocation events that you can use to invoke the function.
- HelloWorldFunction/src/test - Unit tests for the application code. 
- template.yaml - A template that defines the application's AWS resources.

The application uses several AWS resources, including Lambda functions and an API Gateway API. These resources are defined in the `template.yaml` file in this project. You can update the template to add AWS resources through the same deployment process that updates your application code.

If you prefer to use an integrated development environment (IDE) to build and test your application, you can use the AWS Toolkit.  
The AWS Toolkit is an open source plug-in for popular IDEs that uses the SAM CLI to build and deploy serverless applications on AWS. The AWS Toolkit also adds a simplified step-through debugging experience for Lambda function code. See the following links to get started.

* [CLion](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [GoLand](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [IntelliJ](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [WebStorm](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [Rider](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [PhpStorm](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [PyCharm](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [RubyMine](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [DataGrip](https://docs.aws.amazon.com/toolkit-for-jetbrains/latest/userguide/welcome.html)
* [VS Code](https://docs.aws.amazon.com/toolkit-for-vscode/latest/userguide/welcome.html)
* [Visual Studio](https://docs.aws.amazon.com/toolkit-for-visual-studio/latest/user-guide/welcome.html)

## Deploy the sample application

The Serverless Application Model Command Line Interface (SAM CLI) is an extension of the AWS CLI that adds functionality for building and testing Lambda applications. It uses Docker to run your functions in an Amazon Linux environment that matches Lambda. It can also emulate your application's build environment and API.

To use the SAM CLI, you need the following tools.

* SAM CLI - [Install the SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)
* Java8 - [Install the Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Maven - [Install Maven](https://maven.apache.org/install.html)
* Docker - [Install Docker community edition](https://hub.docker.com/search/?type=edition&offering=community)

To build and deploy your application for the first time, run the following in your shell:

```bash
sam build
sam deploy --guided
```

The first command will build the source of your application. The second command will package and deploy your application to AWS, with a series of prompts:

* **Stack Name**: The name of the stack to deploy to CloudFormation. This should be unique to your account and region, and a good starting point would be something matching your project name.
* **AWS Region**: The AWS region you want to deploy your app to.
* **Confirm changes before deploy**: If set to yes, any change sets will be shown to you before execution for manual review. If set to no, the AWS SAM CLI will automatically deploy application changes.
* **Allow SAM CLI IAM role creation**: Many AWS SAM templates, including this example, create AWS IAM roles required for the AWS Lambda function(s) included to access AWS services. By default, these are scoped down to minimum required permissions. To deploy an AWS CloudFormation stack which creates or modifies IAM roles, the `CAPABILITY_IAM` value for `capabilities` must be provided. If permission isn't provided through this prompt, to deploy this example you must explicitly pass `--capabilities CAPABILITY_IAM` to the `sam deploy` command.
* **Save arguments to samconfig.toml**: If set to yes, your choices will be saved to a configuration file inside the project, so that in the future you can just re-run `sam deploy` without parameters to deploy changes to your application.

You can find your API Gateway Endpoint URL in the output values displayed after deployment.

## Use the SAM CLI to build and test locally

Build your application with the `sam build` command.

```bash
java-maven-example03-vscode$ sam build
```

The SAM CLI installs dependencies defined in `HelloWorldFunction/pom.xml`, creates a deployment package, and saves it in the `.aws-sam/build` folder.

Test a single function by invoking it directly with a test event. An event is a JSON document that represents the input that the function receives from the event source. Test events are included in the `events` folder in this project.

Run functions locally and invoke them with the `sam local invoke` command.

```bash
java-maven-example03-vscode$ sam local invoke HelloWorldFunction --event events/event.json
```

The SAM CLI can also emulate your application's API. Use the `sam local start-api` to run the API locally on port 3000.

```bash
java-maven-example03-vscode$ sam local start-api
java-maven-example03-vscode$ curl http://localhost:3000/
```

The SAM CLI reads the application template to determine the API's routes and the functions that they invoke. The `Events` property on each function's definition includes the route and method for each path.

```yaml
      Events:
        HelloWorld:
          Type: Api
          Properties:
            Path: /hello
            Method: get
```

## Add a resource to your application
The application template uses AWS Serverless Application Model (AWS SAM) to define application resources. AWS SAM is an extension of AWS CloudFormation with a simpler syntax for configuring common serverless application resources such as functions, triggers, and APIs. For resources not included in [the SAM specification](https://github.com/awslabs/serverless-application-model/blob/master/versions/2016-10-31.md), you can use standard [AWS CloudFormation](https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/aws-template-resource-type-ref.html) resource types.

## Fetch, tail, and filter Lambda function logs

To simplify troubleshooting, SAM CLI has a command called `sam logs`. `sam logs` lets you fetch logs generated by your deployed Lambda function from the command line. In addition to printing the logs on the terminal, this command has several nifty features to help you quickly find the bug.

`NOTE`: This command works for all AWS Lambda functions; not just the ones you deploy using SAM.

```bash
java-maven-example03-vscode$ sam logs -n HelloWorldFunction --stack-name java-maven-example03-vscode --tail
```

You can find more information and examples about filtering Lambda function logs in the [SAM CLI Documentation](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-logging.html).

## Unit tests

Tests are defined in the `HelloWorldFunction/src/test` folder in this project.

```bash
java-maven-example03-vscode$ cd HelloWorldFunction
HelloWorldFunction$ mvn test
```

## Cleanup

To delete the sample application that you created, use the AWS CLI. Assuming you used your project name for the stack name, you can run the following:

```bash
aws cloudformation delete-stack --stack-name java-maven-example03-vscode
```

## Resources

See the [AWS SAM developer guide](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/what-is-sam.html) for an introduction to SAM specification, the SAM CLI, and serverless application concepts.

Next, you can use AWS Serverless Application Repository to deploy ready to use Apps that go beyond hello world samples and learn how authors developed their applications: [AWS Serverless Application Repository main page](https://aws.amazon.com/serverless/serverlessrepo/)
