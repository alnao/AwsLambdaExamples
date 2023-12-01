
<p align="center">
   <a href="https://www.alnao.it/">
      <img src="https://img.shields.io/badge/alnao-.it-blue?logo=amazoncloudwatch&logoColor=A6C9E2" height="65px;"  />
   </a>
</p>
<p align="center">
  <a href="https://www.alnao.it/aws/">
    <img src="https://img.shields.io/badge/AWS-%23FF9900?style=plastic&logo=AmazonAWS&logoColor=black" style="height:28px;" />
    <img src="https://img.shields.io/badge/Lambda-%23FF9900?style=plastic&logo=AWSlambda&logoColor=black" style="height:28px;" />
  </a>
</p>
<p align="center">
  <img src="https://img.shields.io/badge/Python-14354C?style=plastic&logo=Python&logoColor=white" style="height:28px;" />
  <img src="https://img.shields.io/badge/Java-ED8B00?style=plastic&logo=openjdk&logoColor=white"  style="height:28px;" />
  <img src="https://img.shields.io/badge/Node.js-43853D?style=plastic&logo=node.js&logoColor=white"  style="height:28px;" />

</p>

# Aws Lambda Examples
AWS Lambda Examples by [AlNao](https://www.alnao.it/aws), see [alnao.it/aws](https://www.alnao.it/aws)


Questi esempi non usano il servizio di CloudFormation per gestire le risorse AWS.


## Prerequisiti
Riferimento: [documentazione ufficiale AWS Lambda Java](https://docs.aws.amazon.com/lambda/latest/dg/java-package.html)
- Un account AWS attivo
- La AWS-CLI installata, [documentazione ufficiale](https://docs.aws.amazon.com/it_it/cli/v1/userguide/cli-chap-install.html)
- Utenza tecnica di tipo programmatico configurata su IAM con permessi di esecuzione di CloudFormation e configurazione della AWS-CLI con il comando
    - ```aws configuration```
- La AWS-CLI-SAM installata correttamente, [documentazione ufficiale](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)
- Npm installato nel sistema per l'uso del comando ```serverless``` (abbreviato anche con ```sls```)
- Maven installato nel sistema per l'uso del linguaggio Java
- Pip installato nel sistema per l'uso del linguaggio Python


## Comandi per la creazione con SLS
Comandi per la configurazione di SLS
```
$ npm install -g serverless
$ serverless config credentials --provider aws --key <key> --secret <secret> --profile serverless-admin
$ servless
$ sls
```

## Esempi
- **java-maven-example01-console**: lambda in Java creata con Maven via riga di comando. Comandi per il rilascio da ConsoleWeb, AWS-CLI-SAM oppure AWS-CLI (senza SAM)
- **java-maven-example02-eclipse**: lambda in Java creata con Mavan in Eclipse 
- **java-maven-example03-vscode**: lambda in Java creata con Maven in Visual Studio Code e plugin AWS Toolkit

## Esempi in fase di revisione
- java-maven-example04-s3signature
- java-maven-example05-sqs
- java-maven-example06-excel2csv
- nodejs-crud-dynamo
- nodejs-example03-mailsubscription
- nodejs-example1
- nodejs-example2-todoListDynamoApi
- py-example1
- py-example2-timeout
- py-example3-iam
- py-example4-enviroments-variables
- py-example5-file-manager
- py-example6-sqs-get
- py-example6-sqs-post
- py-example-g1



# AlNao.it
Nessun contenuto in questo repository è stato creato con IA o automaticamente, tutto il codice è stato scritto con molta pazienza da Alberto Nao. Se il codice è stato preso da altri siti/progetti è sempre indicata la fonte. Per maggior informazioni visitare il sito [alnao.it](https://www.alnao.it/).

## License
Public projects 
<a href="https://it.wikipedia.org/wiki/GNU_General_Public_License"  valign="middle"><img src="https://img.shields.io/badge/License-GNU-blue" style="height:22px;"  valign="middle"></a> 
*Free Software!*
