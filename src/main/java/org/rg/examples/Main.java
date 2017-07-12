package org.rg.examples;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Main implements RequestStreamHandler {

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ProxyResponse resp = new ProxyResponse("200", "{\"message\" : \"Hello World\"}");

        String responseString = new ObjectMapper(new JsonFactory()).writeValueAsString(resp);

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseString);
        writer.close();
    }

    private class ProxyResponse {
        private String statusCode;
        private String body;

        public ProxyResponse(String statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public String getBody() {
            return body;
        }
    }
}
