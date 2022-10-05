const AWS=require("aws-sdk");
const TABLE=process.env.TABLE;
const dynamoDb=new AWS.DynamoDB.DocumentClient();
module.exports.createFunction = (event,context,callback) => {
    return {
        statusCose:200,
        body : JSON.stringify({message: "Hello"})
    }
}

/* with async
exports.createFunction = async(event,context) => {
    return {
        statusCose:200,
        body : JSON.stringify({message: "Hello"})
    }
}
*/