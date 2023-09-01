
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
- **java-maven-example01-console**: lambda in Java creata con Maven. Comandi per il rilascio da ConsoleWeb, AWS-CLI-SAM oppure AWS-CLI (senza SAM)

## Esempi in fase di revisione
- java-maven-example02-eclipse
- java-maven-example03-vscode
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