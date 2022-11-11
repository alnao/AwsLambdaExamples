package it.alnao.lambda.examples;

//import java.io.IOException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.S3Object;
//import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.lambda.runtime.events.S3Event;
//import com.amazonaws.services.s3.event.S3EventNotification.S3Entity;

public class Esample1 implements RequestHandler<S3Event, String> {
	public String handleRequest(S3Event s3event, Context context) {
		System.out.println("Funzione lambda eseguita");
		return "OK";
	}
}

/* original from Eclipse template
public class Handler {

  private AmazonS3 s3;

  public Handler() {
    s3 = AmazonS3ClientBuilder.defaultClient();
  }

  public ReturnPojo handler(S3Event event, Context context) throws IOException {
    S3Entity e = event.getRecords().get(0).getS3();
    String bucket = e.getBucket().getName();
    String object = e.getObject().getKey();

    S3Object obj = s3.getObject(bucket,object);

    byte[] bytes = new byte[100];
    S3ObjectInputStream str = obj.getObjectContent();
    str.read(bytes,0,bytes.length);

    return new ReturnPojo(bucket, object, bytes);
  }
}

*/